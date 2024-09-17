package vn.edu.usth.stockdashboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomePagerAdapter extends FragmentStateAdapter {
    private final int PAGE_COUNT = 4;
    private String titles[] = new String[] { "Home", "Bar_Chart", "Credit_Card", "Profile" };
    public HomePagerAdapter(FragmentManager activity) {

        super(activity);
    }
    @Override
    public int getItemCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }
    @Override
    public Fragment createFragment(int page) {
// returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0: return new Home();
            case 1: return new Chart();
            case 2: return new Wallet();
            case 3: return new profile();
            default: return new Home();
        }
    }




    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }

}