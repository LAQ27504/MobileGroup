package vn.edu.usth.stockdashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Market#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Market extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter pagerAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Market() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Market.
     */
    // TODO: Rename and change types and number of parameters
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

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

        // Find the ImageButton for the notification icon
        ImageButton notificationButton = view.findViewById(R.id.imageView4);

        // Set onClickListener to navigate to NotificationFragment
        notificationButton.setOnClickListener(v -> {
            // Begin fragment transaction
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_market, new NotificationFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });
        return view;
    }
}