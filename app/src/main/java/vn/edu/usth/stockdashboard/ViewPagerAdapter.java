package vn.edu.usth.stockdashboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.View;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

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
