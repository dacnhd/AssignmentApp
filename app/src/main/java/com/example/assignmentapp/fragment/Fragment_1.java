package com.example.assignmentapp.fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignmentapp.R;
import com.example.assignmentapp.database.DBHelper;
import com.example.assignmentapp.entity.Spending;
import com.example.assignmentapp.entity.SpendingAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_1 extends Fragment {
    private DBHelper db;
    private List<Spending> listSpending = new ArrayList<>();
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();

        SpendingAdapter adapter = new SpendingAdapter(this, listSpending);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        RecyclerView rvSpending = view.findViewById(R.id.rvSpending);
        rvSpending.setLayoutManager((layoutManager));
        rvSpending.setAdapter(adapter);
        db.close();
        return view;
    }

    private void initData() {
        db = new DBHelper(context);
        listSpending = (List<Spending>) db.getAll();
    }
}