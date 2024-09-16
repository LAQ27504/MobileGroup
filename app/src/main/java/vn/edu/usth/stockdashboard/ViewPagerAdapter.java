package vn.edu.usth.stockdashboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }
    //Viewpager for market layout
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MostViewed();
            case 1:
                return new TopGainers();
            case 2:
                return new TopLosers();
            default:
                return new MostViewed();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // 3 tabs
    }
}
