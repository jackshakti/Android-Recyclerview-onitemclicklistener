package com.recyclerviewdeails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class OfflineMainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<OfflineItemClass> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_activity_main);


        //--> Creating a list
        list = new ArrayList<>();
        list.add(new OfflineItemClass(R.drawable.ic_img_01, "Mario", "Mario@email.com"));
        list.add(new OfflineItemClass(R.drawable.ic_img_02, "John", "John@email.com"));
        list.add(new OfflineItemClass(R.drawable.ic_img_03, "Ian", "John@email.com"));


        recyclerView = findViewById(R.id.id_RecyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        OfflineMyAdapter adapter = new OfflineMyAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        adapter.OnRecyclerViewClickListener(new OfflineMyAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

                Intent intent = new Intent(OfflineMainActivity.this, OfflineDetailsActivity.class);
                intent.putExtra("imagINTENT", list.get(position).getImg() );
                intent.putExtra("nameINTENT", list.get(position).getName());
                intent.putExtra("emailINTENT", list.get(position).getEmail());
                startActivity(intent);
            }
        });

    }
}