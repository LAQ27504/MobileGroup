package vn.edu.usth.stockdashboard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.stockdashboard.CompanyStockItem;
import vn.edu.usth.stockdashboard.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<CompanyStockItem> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CompanyStockItem clikedItem);
    }

    public MyAdapter(List<CompanyStockItem> itemList, OnItemClickListener listener) {
        this.itemList = (itemList != null) ? itemList : new ArrayList<>();
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_stock_item,parent,false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CompanyStockItem currentItem = itemList.get(position);

        holder.imageView.setImageResource(currentItem.getImageID());
        holder.imageView2.setImageResource(currentItem.getChart());
        holder.imageView3.setImageResource(currentItem.getPercent());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentItem); // Passing the entire item object
            }
        });

    }
    public void updateList(List<CompanyStockItem> newList) {
        this.itemList = newList;
        notifyDataSetChanged();  // Refresh RecyclerView
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
        }
    }
}
