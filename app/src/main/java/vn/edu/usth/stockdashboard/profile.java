package vn.edu.usth.stockdashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class profile extends Fragment {
    private ImageView icon1, icon2, icon3, icon4;
    private Button help_button, terms_and_conditions_button, logout_button;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);
        help_button = view.findViewById(R.id.help_button);
        terms_and_conditions_button = view.findViewById(R.id.terms_and_conditions_button);
        logout_button = view.findViewById(R.id.logout_button);



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


        help_button.setOnClickListener(v -> {
            navigateToFragment(new HelpAndResourcesFragment());
        });


        terms_and_conditions_button.setOnClickListener(v -> {
            navigateToFragment(new TermsAndConditionsFragment());
        });

//        logout_button.setOnClickListener(v -> {
//            navigateToFragment(new );
//        });
        return view;
    }


    private void navigateToFragment (Fragment fragment){
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}