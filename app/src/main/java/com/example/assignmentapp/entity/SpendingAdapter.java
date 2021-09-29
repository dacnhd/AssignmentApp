package com.example.assignmentapp.entity;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentapp.R;
import com.example.assignmentapp.fragment.Fragment_1;

import java.util.List;

public class SpendingAdapter extends RecyclerView.Adapter {
    private Fragment_1 fragment1;
    private List<Spending> listSpending;

    public SpendingAdapter(Fragment_1 fragment1, List<Spending> listSpending) {
        this.fragment1 = fragment1;
        this.listSpending = listSpending;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = fragment1.getLayoutInflater().inflate(R.layout.item_detail, parent, false);
        SpendingHolder holder = new SpendingHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SpendingHolder spendingHolder = (SpendingHolder) holder;
        Spending model = listSpending.get(position);
        spendingHolder.tvName.setText(model.getName());
        spendingHolder.tvDetail.setText(model.getDetail());
        spendingHolder.tvMoney.setText(model.getMoney());
        spendingHolder.tvDes.setText(model.getDes());
        spendingHolder.tvCategory.setText(model.getCategory());
        spendingHolder.tvDateAt.setText(model.getDateat());
    }

    @Override
    public int getItemCount() {
        return listSpending.size();
    }

    private class SpendingHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvDetail;
        TextView tvDes;
        TextView tvMoney;
        TextView tvCategory;
        TextView tvDateAt;

        public SpendingHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDetail = itemView.findViewById(R.id.tvDetail);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvDateAt = itemView.findViewById(R.id.tvDetail);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvMoney = itemView.findViewById(R.id.tvMoney);
        }
    }
}
