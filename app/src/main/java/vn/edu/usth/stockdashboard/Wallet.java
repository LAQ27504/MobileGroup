package vn.edu.usth.stockdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Wallet extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter3 myAdapter;
    private ImageView icon1, icon2, icon3, icon4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);

//        icon1.setOnClickListener(v -> {
//            navigateToFragment(new Home());
//        });

        icon2.setOnClickListener(v -> {
            navigateToFragment(new Chart());
        });

        icon3.setOnClickListener(v -> {
            navigateToFragment(new Wallet());
        });

//        icon4.setOnClickListener(v -> {
//            navigateToFragment(new profile());
//        });


        recyclerView = view.findViewById(R.id.recycle_view);
        List<item3> itemList = new ArrayList<>();

        itemList.add(new item3("Buy AMZN", "20 November 2024", "$207.00","Amazon.com Inc."));
        itemList.add(new item3("Buy TSLA", "07 November 2024", "$534.80","Tesla. Inc."));
        itemList.add(new item3("Buy SPOT", "27 October 2024", "$118.40","Spotify Inc."));
        itemList.add(new item3("Buy NFLX", "16 October 2024", "$428.40", "Netflix Inc."));
        itemList.add(new item3("Buy MFST", "5 September 2024", "$378.60", "Microsoft Corp"));


        myAdapter = new MyAdapter3(itemList, clickedItem -> {
            Intent intent = new Intent(getActivity(),DetailTransaction.class);
            intent.putExtra("text1", clickedItem.getAmount());
            intent.putExtra("text2", clickedItem.getDate());
            intent.putExtra("text3", clickedItem.getBuy());
            intent.putExtra("text4", clickedItem.getAmount());
            intent.putExtra("text5", clickedItem.getFullname());
            startActivity(intent);
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return view;
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
