package com.arief.utsmobileprogramming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;
    ListView list;
    String[]NamaKue={
        "kue1",
        "kue2",
        "kue3",
        "kue4",
        "kue5",
    };

    int[]GbrKue = {
        R.drawable.kue1,
        R.drawable.kue2,
        R.drawable.kue3,
        R.drawable.kue4,
        R.drawable.kue5,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();


        KueAdapter adapter = new KueAdapter(this, NamaKue, GbrKue);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Pilihitem = NamaKue[+position];
                Toast.makeText(getApplicationContext(), Pilihitem, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Pesanan.class );
                intent.putExtra("namaKue", Pilihitem);
                startActivity(intent);

            }
        });

    }
}
