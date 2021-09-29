package com.example.assignmentapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignmentapp.R;
import com.example.assignmentapp.database.DBHelper;
import com.example.assignmentapp.fragment.Fragment_1;
import com.example.assignmentapp.fragment.Fragment_2;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;

    private Fragment_1 fragment1;
    private Fragment_2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment();
        db = new DBHelper(this);
        db.getReadableDatabase();
    }

    private void fragment() {
        Button btnFrag1 = findViewById(R.id.btnFrag1);
        Button btnFrag2 = findViewById(R.id.btnFrag2);

        if (fragment1 == null){
            fragment1 = new Fragment_1();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment1);
        fragmentTransaction.commit();

        btnFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment1 == null){
                    fragment1 = new Fragment_1();
                }

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment1);
                fragmentTransaction.commit();
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment2 == null){
                    fragment2 = new Fragment_2();
                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment2);
                fragmentTransaction.commit();
            }
        });
    }
}