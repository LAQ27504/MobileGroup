package vn.edu.usth.stockdashboard.AppFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.stockdashboard.Adapter.MyAdapter;
import vn.edu.usth.stockdashboard.R;
import vn.edu.usth.stockdashboard.CompanyStockItem;

public class SearchFragment extends Fragment {
    private EditText stockName;
    private TextView stockNameDisplay, stockPrice, companyName, percentage;
    private ImageView percentIcon;
    private NetworkImageView companyLogo;
    private Button getStock;
    private static final String FINNHUB_API_KEY = "csmd299r01qn12jeqgi0csmd299r01qn12jeqgig";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);


//        icon1 = view.findViewById(R.id.homeicon);
//        icon2 = view.findViewById(R.id.chart);
//        icon3 = view.findViewById(R.id.pay);
//        icon4 = view.findViewById(R.id.profile);
//
//
//        icon1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                navigateToFragment(0);
//            }
//        });
//
//        icon2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                navigateToFragment(1);
//            }
//        });
//
//        icon3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                navigateToFragment(2);
//            }
//        });
//
//        icon4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                navigateToFragment(3);
//            }
//        });



        stockName = view.findViewById(R.id.stock_name);
        stockNameDisplay = view.findViewById(R.id.stock_name_display);
        stockPrice = view.findViewById(R.id.stock_price);
        companyName = view.findViewById(R.id.company_name);
        percentage = view.findViewById(R.id.change_percentage);
        companyLogo = view.findViewById(R.id.logo);
        percentIcon = view.findViewById(R.id.percent_icon);
        getStock = view.findViewById(R.id.stock_btn);

        getStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stockNameString = stockName.getText().toString().trim();

                if (!stockNameString.isEmpty()) {
                    fetchStockData(stockNameString);
                } else {
                    Toast.makeText(getContext(), "Please enter stock name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton notiButton = view.findViewById(R.id.notiButton);
        notiButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new NotificationFragment(0));
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }

    private void fetchStockData(String stockItem) {
        fetchCompanyLogo(stockItem);
        fetchCompanyName(stockItem);
        fetchStockPriceAndPercentage(stockItem);
    }

    private void fetchCompanyName(String stockItem) {
        String url = "https://finnhub.io/api/v1/search?q=" + stockItem + "&token=" + FINNHUB_API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("CompanyNameResponse", response.toString());

                try {
                    JSONArray resultArray = response.getJSONArray("result");
                    if (resultArray.length() > 0) {
                        JSONObject firstResult = resultArray.getJSONObject(0);
                        String stockNameString = firstResult.getString("symbol");
                        String companyString = firstResult.getString("description");
                        stockNameDisplay.setText(stockNameString);
                        companyName.setText(companyString);
                    } else {
                        Log.e("HomeFragment", "No results found in the response");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HomeFragment", "Error retrieving company name" + error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
    }

    private void fetchStockPriceAndPercentage(String stockItem) {
        String url = "https://finnhub.io/api/v1/quote?symbol=" + stockItem + "&token=" + FINNHUB_API_KEY;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String priceString = response.getString("c");
                    String changePercentString = response.getString("dp");
                    if (!changePercentString.isEmpty()) {
                        try {
                            double percentValue = Double.parseDouble(changePercentString.trim());
                            if (percentValue > 0) {
                                percentage.setTextColor(Color.parseColor("#32D49D"));
                                percentIcon.setImageResource(R.drawable.up);
                            } else {
                                percentage.setTextColor(Color.parseColor("#FF5353"));
                                percentIcon.setImageResource(R.drawable.down);
                            }
                        } catch (NumberFormatException e) {
                            percentage.setTextColor(Color.WHITE);
                        }
                    }
                    stockPrice.setText("$" + priceString);
                    percentage.setText(changePercentString + "%");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HomeFragment", "Error fetching stock price and change percent: " + error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).addToRequestQueue(request);
    }

    private void fetchCompanyLogo(String stockName) {
        String url = "https://finnhub.io/api/v1/stock/profile2?symbol=" + stockName + "&token=" + FINNHUB_API_KEY;
        Log.d("APIRequest", "Fetching logo from URL: " + url);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("APIResponse", "Response: " + response.toString());
                        try {
                            if (response.has("logo") && !response.getString("logo").isEmpty()) {
                                String logoUrl = response.getString("logo");
                                Log.d("APIResponse", "Logo URL: " + logoUrl);

                                ImageLoader imageLoader = new ImageLoader(
                                        VolleySingleton.getInstance(getContext()).getRequestQueue(),
                                        new LruBitmapCache()
                                );

                                companyLogo.setImageUrl(logoUrl, imageLoader);
                            } else {
                                Toast.makeText(getContext(), "Logo not available for this company", Toast.LENGTH_SHORT).show();
                                Log.d("APIResponse", "Logo field is empty or missing");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(), "Error fetching logo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("APIError", "Error retrieving logo: " + error.getMessage());
                Toast.makeText(getContext(), "Error retrieving logo", Toast.LENGTH_SHORT).show();
            }
        });

        VolleySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    private void navigateToFragment(int page) {
        MainAppFragment.getInstance().setFragment(page);
    }
}