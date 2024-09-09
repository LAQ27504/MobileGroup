package vn.edu.usth.stockdashboard;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImage1, detailImage2, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage1 = findViewById(R.id.detail_image1);
        detailImage2 = findViewById(R.id.detail_image2);
        backButton = findViewById(R.id.backbutton);

        // Get data from intent
        int image1 = getIntent().getIntExtra("image1", 0);
        int image2 = getIntent().getIntExtra("image2", 0);


        // Set images to ImageViews
        detailImage1.setImageResource(image1);
        detailImage2.setImageResource(image2);

        backButton.setOnClickListener(v -> {
            finish();
        });

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
