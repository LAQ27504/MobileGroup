package vn.edu.usth.stockdashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

public class profile extends Fragment {
    private ImageView icon1, icon2, icon3, icon4;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);
        LinearLayout help_button = view.findViewById(R.id.help_button);
        LinearLayout conditions_button = view.findViewById(R.id.term_and_conditions_button);


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

        conditions_button.setOnClickListener(v -> {
            navigateToFragment(new TermsAndConditionsFragment());
        });
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

