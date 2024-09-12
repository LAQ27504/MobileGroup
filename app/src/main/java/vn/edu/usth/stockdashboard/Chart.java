package vn.edu.usth.stockdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Chart extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter2 myAdapter;
    private List<item> mostViewedItems, topGainersItems, topLosersItems;

    private TextView MostViewed, TopGainers, TopLosers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        recyclerView = view.findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        MostViewed = view.findViewById(R.id.most_viewed);
        TopGainers = view.findViewById(R.id.top_gainers);
        TopLosers = view.findViewById(R.id.top_losers);

        // Initialize item lists
        init();

        // Default: show the "Most Viewed" list
        myAdapter = new MyAdapter2(mostViewedItems, clickedItem -> moveToDetailActivity(clickedItem));
        recyclerView.setAdapter(myAdapter);

        // Set onClick listeners for each TextView
        MostViewed.setOnClickListener(v -> {
            MostViewed.setBackgroundResource(R.drawable.textbar1);
            TopGainers.setBackgroundResource(R.drawable.textbar_unselected);
            TopLosers.setBackgroundResource(R.drawable.textbar_unselected);
            myAdapter.updateList(mostViewedItems);  // Update adapter with Most Viewed items
        });

        TopGainers.setOnClickListener(v -> {
            MostViewed.setBackgroundResource(R.drawable.textbar_unselected);
            TopGainers.setBackgroundResource(R.drawable.textbar1);
            TopLosers.setBackgroundResource(R.drawable.textbar_unselected);
            myAdapter.updateList(topGainersItems);  // Update adapter with Top Gainers items
        });

        TopLosers.setOnClickListener(v -> {
            MostViewed.setBackgroundResource(R.drawable.textbar_unselected);
            TopGainers.setBackgroundResource(R.drawable.textbar_unselected);
            TopLosers.setBackgroundResource(R.drawable.textbar1);
            myAdapter.updateList(topLosersItems);  // Update adapter with Top Losers items
        });

        return view;
    }

    private void init() {
        // Initialize the lists
        mostViewedItems = new ArrayList<>();
        topGainersItems = new ArrayList<>();
        topLosersItems = new ArrayList<>();

        // Add items to the lists
        item amazonItem = new item(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph);
        item msftItem = new item(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph);
        item teslaItem = new item(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph);
        item spotItem = new item(R.drawable.spot, R.drawable.spotchart, R.drawable.spotpercent, R.drawable.spotfull, R.drawable.spotgraph);
        item nflxItem = new item(R.drawable.nflx, R.drawable.nflxchart, R.drawable.nflxpercent, R.drawable.nflxfull, R.drawable.nflxgraph);

        // Add items to mostViewedItems
        mostViewedItems.add(amazonItem);
        mostViewedItems.add(msftItem);
        mostViewedItems.add(teslaItem);
        mostViewedItems.add(spotItem);
        mostViewedItems.add(nflxItem);

        // Add items to topGainersItems
        topGainersItems.add(teslaItem);
        topGainersItems.add(amazonItem);
        topGainersItems.add(spotItem);

        // Add items to topLosersItems
        topLosersItems.add(msftItem);
        topLosersItems.add(nflxItem);
    }


    private void moveToDetailActivity(item clickedItem) {
        Intent intent = new Intent(getActivity(),DetailActivity.class);
        intent.putExtra("image1", clickedItem.getFullImage());
        intent.putExtra("image2", clickedItem.getGraphImage());
        startActivity(intent);
    }


    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}

