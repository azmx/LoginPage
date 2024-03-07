package com.example.loginpage;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterListMakanan extends RecyclerView.Adapter <AdapterListMakanan.ViewHolder> {

    List<item> listData;
    private ItemClickListener mClickListener;

    private LayoutInflater mInflater;
    public AdapterListMakanan(List<item> listData,Context context)
    {
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public AdapterListMakanan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_view_rows, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListMakanan.ViewHolder holder, int position) {

        holder.tvMakananFav.setText(listData.get(position).getName());
        holder.tvDescription.setText(listData.get(position).getDesc());
        holder.imageView.setImageResource(listData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvMakananFav,tvDescription;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDesc);
            tvMakananFav = itemView.findViewById(R.id.tvname);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }

    }
    item getItem(int id) {
        return listData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
