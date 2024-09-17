package vn.edu.usth.stockdashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.stockdashboard.Adapter.ViewPagerAdapter;
import vn.edu.usth.stockdashboard.AppFragment.NotificationFragment;

public class Market extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter pagerAdapter;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Market() {
    }

    public static Market newInstance(String param1, String param2) {
        Market fragment = new Market();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);

        // Set up the adapter
        pagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        // Set up TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            View customTabView = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom, null);
            TextView tabText = customTabView.findViewById(R.id.tab_text);

            switch (position) {
                case 0:
                    tabText.setText("Most Viewed");
                    break;
                case 1:
                    tabText.setText("Top Gainers");
                    break;
                case 2:
                    tabText.setText("Top Losers");
                    break;
            }

            tab.setCustomView(customTabView); // Set the custom view for the tab
        }).attach();

        ImageButton notiButton = view.findViewById(R.id.notiButton);
        notiButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.home, new NotificationFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;

    }
}