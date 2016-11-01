package com.arief.utsmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by arif1 on 11/1/2016.
 */

public class Pesanan extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesanan);

        SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        TextView tVKue = (TextView) findViewById(R.id.tVKue);
        final EditText txtPesan = (EditText) findViewById(R.id.txtPesan);
        final EditText txtReceiver = (EditText) findViewById(R.id.txtReceiver);
        final EditText txtPengirim = (EditText) findViewById(R.id.txtPengirim);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        Bundle bundle = getIntent().getExtras();
        String namaKue = bundle.getString("namaKue");

        tVKue.setText(namaKue);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHasilPesanan = new Intent(Pesanan.this, HasilPesanan.class);
                toHasilPesanan.putExtra("isiPesan", txtPesan.getText().toString());
                toHasilPesanan.putExtra("isiReceiver", txtReceiver.getText().toString());
                toHasilPesanan.putExtra("isiPengirim", txtPengirim.getText().toString());

                startActivity(toHasilPesanan);
            }
        });

    }
}
