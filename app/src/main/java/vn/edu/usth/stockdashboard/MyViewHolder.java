package vn.edu.usth.stockdashboard;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;

    public CardView getCardView() {
        return cardView;
    }

    private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    private ImageView imageView2;

    public ImageView getImageView2() {
        return imageView2;
    }

    private ImageView imageView3;

    public ImageView getImageView3() {
        return imageView3;
    }

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardview);
        imageView = itemView.findViewById(R.id.logo_view);
        imageView2 = itemView.findViewById(R.id.item_chart);
        imageView3 = itemView.findViewById(R.id.item_percent);
    }
}