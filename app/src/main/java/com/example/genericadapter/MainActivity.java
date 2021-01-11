package com.example.genericadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.genericadapter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BaseAdapter baseAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // creates ArrayList and adds elements to it
        ArrayList<ExampleItem1> list1 = new ArrayList<>();
        list1.add(new ExampleItem1(R.drawable.ic_android));
        list1.add(new ExampleItem1(R.drawable.ic_snow));
        list1.add(new ExampleItem1(R.drawable.ic_airplane));

        ArrayList<ExampleItem2> list2 = new ArrayList<>();
        list2.add(new ExampleItem2("Text1"));
        list2.add(new ExampleItem2("Text2"));
        list2.add(new ExampleItem2("Text3"));

        mainBinding.recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        baseAdapter = new BaseAdapter(this, R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(layoutManager);
        mainBinding.recyclerView.setAdapter(baseAdapter);
    }
}