package vn.edu.usth.stockdashboard.AppFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import vn.edu.usth.stockdashboard.R;


public class TermsAndConditionsFragment extends Fragment {
    private ImageView icon1, icon2, icon3, icon4, back_button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);


        icon1 = view.findViewById(R.id.homeicon);
        icon2 = view.findViewById(R.id.chart);
        icon3 = view.findViewById(R.id.pay);
        icon4 = view.findViewById(R.id.profile);
        back_button = view.findViewById(R.id.backbutton);


        icon1.setOnClickListener(v -> {
            navigateToFragment(new HomeFragment());
        });

        icon2.setOnClickListener(v -> {
            navigateToFragment(new ChartFragment());
        });

        icon3.setOnClickListener(v -> {
            navigateToFragment(new WalletFragment());
        });

        icon4.setOnClickListener(v -> {
            navigateToFragment(new ProfileFragment());
        });

        back_button.setOnClickListener(v -> {
            navigateToFragment(new ProfileFragment());
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