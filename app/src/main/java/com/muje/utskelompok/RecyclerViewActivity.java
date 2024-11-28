package com.muje.utskelompok;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        itemList.addAll(getListItems());
        showRecyclerList();
    }

    public ArrayList<Item> getListItems() {
        String[] dataName = getResources().getStringArray(R.array.item_names);
        String[] dataDescription = getResources().getStringArray(R.array.item_descriptions);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.item_images);
        ArrayList<Item> listItem = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Item item = new Item();
            item.setName(dataName[i]);
            item.setDescription(dataDescription[i]);
            item.setImageResId(dataPhoto.getResourceId(i, -1));
            listItem.add(item);
        }

        dataPhoto.recycle();
        return listItem;
    }

    private void showSelectedItem(Item item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, item.getName());
        intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, item.getDescription());
        intent.putExtra(DetailActivity.EXTRA_IMAGE, item.getImageResId());
        startActivity(intent);
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickCallback(this::showSelectedItem);
    }
}