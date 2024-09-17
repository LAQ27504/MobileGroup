package vn.edu.usth.stockdashboard.AppFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.stockdashboard.Adapter.MyAdapter;
import vn.edu.usth.stockdashboard.CompanyStockItem;
import vn.edu.usth.stockdashboard.R;


public class MostViewedFragment extends Fragment {


    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    public MostViewedFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static MostViewedFragment newInstance(String param1, String param2) {
        MostViewedFragment fragment = new MostViewedFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_viewed, container, false);

        recyclerView = view.findViewById(R.id.recycle_view);
        List<CompanyStockItem> itemList = new ArrayList<>();
        itemList.add(new CompanyStockItem(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph));
        itemList.add(new CompanyStockItem(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph));
        itemList.add(new CompanyStockItem(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph));
        itemList.add(new CompanyStockItem(R.drawable.spot, R.drawable.spotchart, R.drawable.spotpercent, R.drawable.spotfull, R.drawable.spotgraph));
        itemList.add(new CompanyStockItem(R.drawable.nflx, R.drawable.nflxchart, R.drawable.nflxpercent, R.drawable.nflxfull, R.drawable.nflxgraph));

        myAdapter = new MyAdapter(itemList);


        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));


        return view;
    }
}