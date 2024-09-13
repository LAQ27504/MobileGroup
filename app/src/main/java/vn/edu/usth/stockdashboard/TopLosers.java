package vn.edu.usth.stockdashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class TopLosers extends Fragment {


    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    public TopLosers() {
    }

    // TODO: Rename and change types and number of parameters
    public static TopLosers newInstance(String param1, String param2) {
        TopLosers fragment = new TopLosers();
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
        View view = inflater.inflate(R.layout.fragment_top_losers, container, false);

        recyclerView = view.findViewById(R.id.recycle_view);
        List<item> itemList = new ArrayList<>();
        itemList.add(new item(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph));
        itemList.add(new item(R.drawable.nflx, R.drawable.nflxchart, R.drawable.nflxpercent, R.drawable.nflxfull, R.drawable.nflxgraph));

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return view;
    }
}