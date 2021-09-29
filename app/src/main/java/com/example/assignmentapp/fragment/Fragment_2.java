package com.example.assignmentapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.assignmentapp.R;
import com.example.assignmentapp.activity.MainActivity;
import com.example.assignmentapp.database.DBHelper;
import com.example.assignmentapp.entity.Category;

import java.util.Collections;
import java.util.List;

public class Fragment_2 extends Fragment implements View.OnClickListener {
    private EditText edName;
    private EditText edDes;
    private EditText edDetail;
    private EditText edMoney;
    private EditText edDateAt;
    private Spinner spinner;
    private Button btAdd;
    private MainActivity mainActivity;
    private DBHelper db;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        edName = view.findViewById(R.id.edName);
        edDes = view.findViewById(R.id.edDes);
        edDetail = view.findViewById(R.id.edDetail);
        edMoney = view.findViewById(R.id.edMoney);
        edDateAt = view.findViewById(R.id.edDateAt);
        btAdd = view.findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);

        List<Category> listCategory= (List<Category>) db.getAllCategory();
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<List<Category>> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, Collections.singletonList(listCategory));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == btAdd){
            onAdd();
        }
    }

    private void onAdd() {
        if (edName.getText().toString().isEmpty()){
            Toast.makeText(mainActivity, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        String isAdd = db.add(edName.getText().toString(),
                edDes.getText().toString(),
                edDetail.getText().toString(),
                edMoney.getText().toString(),
                edDateAt.getText().toString(),
                spinner.getSelectedItem().toString());
        Toast.makeText(mainActivity, isAdd, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(mainActivity, Fragment_1.class);
        startActivity(intent);
    }
}