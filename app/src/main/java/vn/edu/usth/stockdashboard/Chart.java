package vn.edu.usth.stockdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.annotation.ColorInt;
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
    private ImageView icon1, icon2, icon3, icon4;
    private MyAdapter2 myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);


        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);


        icon1.setOnClickListener(v -> {
            navigateToFragment(new Home());
        });

        icon2.setOnClickListener(v -> {
            navigateToFragment(new Chart());
        });

        icon3.setOnClickListener(v -> {
            navigateToFragment(new Wallet());
        });

        icon4.setOnClickListener(v -> {
            navigateToFragment(new profile());
        });

        recyclerView = view.findViewById(R.id.recycle_view);
        List<item> itemList = new ArrayList<>();
        itemList.add(new item(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph));
        itemList.add(new item(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph));
        itemList.add(new item(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph));
        itemList.add(new item(R.drawable.spot, R.drawable.spotchart, R.drawable.spotpercent, R.drawable.spotfull, R.drawable.spotgraph));
        itemList.add(new item(R.drawable.nflx, R.drawable.nflxchart, R.drawable.nflxpercent, R.drawable.nflxfull, R.drawable.nflxgraph));

        // Initialize the adapter with the item list and a click listener
        myAdapter = new MyAdapter2(itemList, clickedItem -> {
            // Pass the clicked item's full and graph images to DetailActivity
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("image1", clickedItem.getFullImage());
            intent.putExtra("image2", clickedItem.getGraphImage());
            startActivity(intent);
        });

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return view;
    }

    private void moveToDetailActivity(item clickedItem) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
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
