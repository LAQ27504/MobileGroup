package vn.edu.usth.stockdashboard.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.stockdashboard.CompanyStockItem;
import vn.edu.usth.stockdashboard.ItemViewHolder;
import vn.edu.usth.stockdashboard.R;

public class MyAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<CompanyStockItem> itemList;

    public MyAdapter(List<CompanyStockItem> itemList) {
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_stock_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CompanyStockItem item = itemList.get(position);
        holder.getCompanyLogo().setImageResource(item.getImageID());
        holder.getImageView2().setImageResource(item.getChart());
        holder.getImageView3().setImageResource(item.getPercent());

    }
}
