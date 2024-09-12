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
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(item clikedItem);
    }

    public MyAdapter2(List<item> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempage2,parent,false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        item currentItem = itemList.get(position);

        holder.imageView.setImageResource(currentItem.getImageID());
        holder.imageView2.setImageResource(currentItem.getChart());
        holder.imageView3.setImageResource(currentItem.getPercent());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentItem); // Passing the entire item object
            }
        });

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private ImageView imageView2;
        private ImageView imageView3;
        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.logo_view);
            imageView2 = itemView.findViewById(R.id.item_chart);
            imageView3 = itemView.findViewById(R.id.item_percent);
<<<<<<< HEAD

=======
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
>>>>>>> 82e43b51fbf108fda3915ea2ab7fb39925101d4f
        }
    }
}
