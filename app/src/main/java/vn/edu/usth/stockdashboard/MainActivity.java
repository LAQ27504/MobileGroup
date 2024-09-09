package vn.edu.usth.stockdashboard;

import static vn.edu.usth.stockdashboard.R.*;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.activity_main);

        if (savedInstanceState == null) {
            // Add Home fragment to the fragment container
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Home())
                    .commit();
        }
    }
}