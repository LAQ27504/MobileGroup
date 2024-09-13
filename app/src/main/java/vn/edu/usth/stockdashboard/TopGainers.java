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


public class TopGainers extends Fragment {


    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    public TopGainers() {
    }

    // TODO: Rename and change types and number of parameters
    public static TopGainers newInstance(String param1, String param2) {
        TopGainers fragment = new TopGainers();
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
        View view = inflater.inflate(R.layout.fragment_top_gainers, container, false);

        recyclerView = view.findViewById(R.id.recycle_view);
        List<item> itemList = new ArrayList<>();
        itemList.add(new item(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph));
        itemList.add(new item(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph));
        itemList.add(new item(R.drawable.spot, R.drawable.spotchart, R.drawable.spotpercent, R.drawable.spotfull, R.drawable.spotgraph));

        myAdapter = new MyAdapter(itemList);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return view;
    }
}