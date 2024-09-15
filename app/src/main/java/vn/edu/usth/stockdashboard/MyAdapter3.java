package vn.edu.usth.stockdashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    private List<item3> itemList;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(item3 clikedItem);
    }

    public MyAdapter3(List<item3> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        item3 currentItem = itemList.get(position);
        holder.textView.setText(currentItem.getBuy());
        holder.textView2.setText(currentItem.getDate());
        holder.textView3.setText(currentItem.getAmount());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(currentItem); // Passing the entire item object
            }
        });

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            textView=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            textView3=itemView.findViewById(R.id.text3);
        }
    }
}
