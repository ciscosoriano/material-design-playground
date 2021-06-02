package com.qc.ux.materialdesignplayground;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qc.ux.materialdesignplayground.databinding.SampleDataListItemBinding;

import java.util.ArrayList;

public class SampleDataListAdapter extends RecyclerView.Adapter<SampleDataListAdapter.ViewHolder> {
    private SampleDataListItemBinding sampleListItemBinding;
    private ArrayList<SampleDataItemModel> sampleData;
    private SampleDataLongClickListener longClickListener;
    private Context context;

    public interface SampleDataLongClickListener {
        void onItemLongClick(int position);
    }

    public SampleDataListAdapter(ArrayList<SampleDataItemModel> sampleData, SampleDataLongClickListener longClickListener) {
        this.sampleData = sampleData;
        this.longClickListener = longClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView textViewListTitle;
        private TextView textViewListSecondaryText;

        public ViewHolder(SampleDataListItemBinding sampleListItemBinding) {
            super(sampleListItemBinding.getRoot());
            this.textViewListTitle = sampleListItemBinding.textViewListTitle;
            this.textViewListSecondaryText = sampleListItemBinding.textViewSecondaryText;
            sampleListItemBinding.getRoot().setOnLongClickListener(this::onLongClick);
        }

        @Override
        public boolean onLongClick(View v) {
            longClickListener.onItemLongClick(getAdapterPosition());
            return true;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        sampleListItemBinding = SampleDataListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(sampleListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleDataListAdapter.ViewHolder holder, int position) {
        SampleDataItemModel item = sampleData.get(position);
        holder.textViewListTitle.setText(item.getTitle());
        holder.textViewListSecondaryText.setText(item.getSecondaryText());
    }

    @Override
    public int getItemCount() {
        return sampleData.size();
    }
}
