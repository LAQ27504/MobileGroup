package vn.edu.usth.stockdashboard.AppFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.stockdashboard.DetailActivity;
import vn.edu.usth.stockdashboard.MainActivity;
import vn.edu.usth.stockdashboard.Adapter.MyAdapter;
import vn.edu.usth.stockdashboard.R;
import vn.edu.usth.stockdashboard.CompanyStockItem;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView icon1, icon2, icon3, icon4;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);


        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                navigateToFragment(0);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                navigateToFragment(1);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                navigateToFragment(2);
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                navigateToFragment(3);
            }
        });

        recyclerView = view.findViewById(R.id.recycle_view);  // Use the view object to find the RecyclerView
        List<CompanyStockItem> itemList = new ArrayList<>();
        itemList.add(new CompanyStockItem(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph,R.drawable.spotgraph, R.drawable.teslagraph));
        itemList.add(new CompanyStockItem(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph,R.drawable.nflxgraph, R.drawable.msftgraph));
        itemList.add(new CompanyStockItem(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph, R.drawable.amzngraph, R.drawable.spotgraph));

        // Initialize the adapter with the item list and a click listener
        myAdapter = new MyAdapter(itemList, clickedItem -> {
            // Pass the clicked item's full and graph images to DetailActivity
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("image1", clickedItem.getFullImage());
            intent.putExtra("image2", clickedItem.getGraphImage());
            intent.putExtra("hourlygraph", clickedItem.getGraphImage());
            intent.putExtra("weeklygraph", clickedItem.getWeekly());
            intent.putExtra("dailygraph", clickedItem.getDaily());

            startActivity(intent);
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        ImageButton notiButton = view.findViewById(R.id.notiButton);
        notiButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new NotificationFragment(0));
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }

    private void navigateToFragment(int page) {
        MainAppFragment.getInstance().setFragment(page);
    }


}
