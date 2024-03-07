package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class makananFavList extends  AppCompatActivity implements AdapterListMakanan.ItemClickListener{

    RecyclerView rvMakanan;
    List<item> listDataMakanan = new ArrayList<>();
    AdapterListMakanan adapter;

    int[] foodImage = {R.drawable.ayam, R.drawable.cireng, R.drawable.mie,R.drawable.fb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan_fav_list);

        rvMakanan = findViewById(R.id.rvMakanan);
        listDataMakanan = new ArrayList<>();

        foodsMenu();

        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListMakanan(listDataMakanan, this);
        rvMakanan.setAdapter(adapter);
        adapter.setClickListener(this);




    }
    private void foodsMenu() {
        String[] foodsNameRv = getResources().getStringArray(R.array.foodname);
        String[] foodsDescriptionRv = getResources().getStringArray(R.array.description);
        for (int i = 0; i < foodsNameRv.length; i++) {
            listDataMakanan.add(new item(foodsNameRv[i], foodsDescriptionRv[i], foodImage[i]));
        }
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getName()+ " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}