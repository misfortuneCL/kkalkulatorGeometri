package com.example.customer.kalkulatorgeometri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.view.View;


import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    Spinner pilih;
    EditText txt1,txt2;
    TextView txtLuas, txtKell ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.txtBil1);
        txt2=(EditText)findViewById(R.id.txtBil2);
        txtLuas = (TextView)findViewById(R.id.txt_luas);
        txtKell = (TextView)findViewById(R.id.txt_kell);
        pilih = (Spinner) findViewById(R.id.spinPilih);


        List<String> list = new ArrayList<String>();

        list.add("Persegi Panjang");

        list.add("Lingkaran");

        list.add("Segitiga Siku - Siku");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilih.setAdapter(dataAdapter);

        Button  btnHitung=(Button)findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                String panjang =txt1.getText().toString();

                String lebar =txt2.getText().toString();

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double luas = 0;
                double kell = 0;

                String pilihan=pilih.getSelectedItem().toString();

                if(pilihan.equalsIgnoreCase("Persegi Panjang")){

                    luas = p * l;
                    kell = (2 * p) + (2 * l);

                }

                else if(pilihan.equalsIgnoreCase("Lingkaran")){

                    luas = Math.PI * (p * p);
                    kell = Math.PI * (2 * p);

                }

                else if(pilihan.equalsIgnoreCase("Segitiga Siku - Siku")){

                    luas = (p * l) / 2;
                    kell = (p + l + ( Math.sqrt((p * p) + (l * l))));

                }

                txtLuas.setText("Luas dari bangun datar : " + luas);
                txtKell.setText("Keliling dari bangun datar : " + kell);

            }
        });
    }
}