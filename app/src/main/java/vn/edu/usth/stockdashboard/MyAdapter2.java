package vn.edu.usth.stockdashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private List<item> itemList;

    public MyAdapter2(List<item> itemList) {
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempage2,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageID());
        holder.imageView2.setImageResource(item.getChart());
        holder.imageView3.setImageResource(item.getPercent());

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private ImageView imageView2;
        private ImageView imageView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.logo_view);
            imageView2 = itemView.findViewById(R.id.item_chart);
            imageView3 = itemView.findViewById(R.id.item_percent);
        }
    }
}
