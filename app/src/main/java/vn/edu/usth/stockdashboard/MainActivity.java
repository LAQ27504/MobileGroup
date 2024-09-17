package vn.edu.usth.stockdashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
<<<<<<< HEAD

=======
import com.google.android.material.snackbar.Snackbar;
>>>>>>> vhv
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
<<<<<<< HEAD

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import vn.edu.usth.stockdashboard.Adapter.PageAdapter;
import vn.edu.usth.stockdashboard.AppFragment.HomeFragment;
import vn.edu.usth.stockdashboard.AppFragment.MainAppFragment;
=======
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import vn.edu.usth.stockdashboard.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

>>>>>>> vhv

public class MainActivity extends AppCompatActivity {
    private static MainActivity Instance;


    public static MainActivity getInstance() {
        return Instance;
    }

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        MainActivity.Instance = this;
=======
>>>>>>> vhv
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
<<<<<<< HEAD
//
//        LoginFragment loginFragment = new LoginFragment();
//
//        getSupportFragmentManager().beginTransaction().add(R.id.main, loginFragment).commit();


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (savedInstanceState == null) {
            // Add Home fragment to the fragment container
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainAppFragment())
                    .commit();
        }
    }


=======

        if (savedInstanceState == null) {
            // Add Home fragment to the fragment container
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, new LoginFragment())
                    .commit();
        }

    }
>>>>>>> vhv
}