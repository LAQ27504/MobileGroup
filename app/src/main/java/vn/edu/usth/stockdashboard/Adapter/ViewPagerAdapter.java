package vn.edu.usth.stockdashboard.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.stockdashboard.AppFragment.MostViewedFragment;
import vn.edu.usth.stockdashboard.AppFragment.TopGainersFragment;
import vn.edu.usth.stockdashboard.AppFragment.TopLosersFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MostViewedFragment();
            case 1:
                return new TopGainersFragment();
            case 2:
                return new TopLosersFragment();
            default:
                return new MostViewedFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 3; // 3 tabs
    }
}
