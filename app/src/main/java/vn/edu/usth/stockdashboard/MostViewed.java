package vn.edu.usth.stockdashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MostViewed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MostViewed extends Fragment {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MostViewed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MostViewed.
     */
    // TODO: Rename and change types and number of parameters
    public static MostViewed newInstance(String param1, String param2) {
        MostViewed fragment = new MostViewed();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_viewed, container, false);

        recyclerView = view.findViewById(R.id.recycle_view);
        List<item> itemList = new ArrayList<>();
        itemList.add(new item(R.drawable.amazon, R.drawable.amazon_chart, R.drawable.amazon_percent, R.drawable.amznfull, R.drawable.amzngraph));
        itemList.add(new item(R.drawable.msft, R.drawable.msft_chart, R.drawable.msft_percent, R.drawable.msftfull, R.drawable.msftgraph));
        itemList.add(new item(R.drawable.tesla, R.drawable.tesla_chart, R.drawable.tesla_percent, R.drawable.teslafull, R.drawable.teslagraph));
        itemList.add(new item(R.drawable.spot, R.drawable.spotchart, R.drawable.spotpercent, R.drawable.spotfull, R.drawable.spotgraph));
        itemList.add(new item(R.drawable.nflx, R.drawable.nflxchart, R.drawable.nflxpercent, R.drawable.nflxfull, R.drawable.nflxgraph));

        myAdapter = new MyAdapter(itemList);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return view;
    }
}