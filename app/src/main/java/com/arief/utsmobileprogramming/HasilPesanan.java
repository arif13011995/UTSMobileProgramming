package com.arief.utsmobileprogramming;

/**
 * Created by arif1 on 11/1/2016.
 */

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

public class HasilPesanan extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_pesanan);

        final SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();

        TextView tVReceiver = (TextView) findViewById(R.id.tVReceiver);
        TextView tVPesan= (TextView) findViewById(R.id.tVPesan);
        TextView tVPengirim = (TextView) findViewById(R.id.tVPengirim);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);



        Bundle hasilPesan = getIntent().getExtras();
        String isiPesan = hasilPesan.getString("isiPesan");
        String isiPengirim = hasilPesan.getString("isiPengirim");
        String isiReceiver = hasilPesan.getString("isiReceiver");


        tVReceiver.setText(isiReceiver);
        tVPengirim.setText(isiPengirim);
        tVPesan.setText(isiPesan);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(HasilPesanan.this, MainActivity.class);
                startActivity(k);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutUser();
            }
        });

    }
}
