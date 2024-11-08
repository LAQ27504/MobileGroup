package vn.edu.usth.stockdashboard.Operation;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class GetAPI {
    private final String taga = "API_GETTING";
    private String[] headerData = {"AAPL", "AMD", "AMZN", "IWM"};
    private Context contextForDataQueue;
    private static final String API_KEY = "Z07VZCFXG1ZNK4CL";
    public GetAPI(Context contextForDataQueue){
        this.contextForDataQueue = contextForDataQueue;
        for (String data: headerData
             ) {
            this.fetchCompStockName(data, "2024-11-01", "2024-11-08");
        }
    }

    public void fetchCompStockName(String stockName, String start, String end){
        String url = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + stockName + "&apikey=" + API_KEY;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String companyNameString = response.getString("Name");
                    Log.i(taga, "company name " + companyNameString);
                    //companyName.setText("Company: " + companyNameString + "\n");
                    fetchStockPrice(stockName, start, end);
                    fetchLatestPrice(stockName);
                } catch (JSONException e) {
                    e.printStackTrace();
                    //stockPrice.setText("Error retrieving company name");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                //companyName.setText("Error fetching company name");
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(contextForDataQueue);
        requestQueue.add(jsonObjectRequest);
    }

    private void fetchStockPrice(String stockName, String start, String end) {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockName + "&apikey=" + API_KEY;

        // Create a new request queue
        RequestQueue requestQueue = Volley.newRequestQueue(contextForDataQueue);

        // JSON request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Parse the response
                            JSONObject timeSeries = response.getJSONObject("Time Series (Daily)");
                            displayStockInRange(timeSeries, start, end);
                            Log.d("APIResponse", response.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //stockPrice.setText("Failed to parse data.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        //stockPrice.setText("Error retrieving data.");
                    }
                });

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
    }

    private void displayStockInRange(JSONObject timeSeries, String start, String end) {
        StringBuilder stockData = new StringBuilder();
        boolean withinRange = false;

        try {
            Iterator<String> dates = timeSeries.keys();
            while (dates.hasNext()) {
                String date = dates.next();
                if (date.compareTo(start) >= 0 && date.compareTo(end) <= 0) {
                    withinRange = true;
                    JSONObject dayData = timeSeries.getJSONObject(date);
                    String closePrice = dayData.getString("4. close");
                    stockData.append(date).append(": $").append(closePrice).append("\n");
                }
                if (withinRange && date.compareTo(start) < 0) {
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            //stockPrice.setText("Error displaying data.");
        }

        if (stockData.length() > 0) {
            //stockPrice.setText(stockData.toString());
            Log.i(taga, stockData.toString());
        } else {
            //stockPrice.setText("No data available for this date range.");
        }
    }

    private void fetchLatestPrice(String symbol) {
        String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;

        RequestQueue requestQueue = Volley.newRequestQueue(this.contextForDataQueue);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject globalQuote = response.getJSONObject("Global Quote");
                            String change_percent = globalQuote.getString("10. change percent");

                            // Display the latest price
                            //percentage.setText("change percent: " + change_percent);
                            Log.i(taga, "Change percent: " + change_percent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //percentage.setText("Failed to get the latest percantage change.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        //percentage.setText("Error retrieving price.");
                    }
                });

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
    }



}
