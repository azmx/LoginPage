package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class kalkulator extends AppCompatActivity {
    EditText text_1;
    EditText text_2;
    Spinner spOperator;
    Button  btnHitung;

    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator2);
        tvHasil = findViewById(R.id.tvHasil);
        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        spOperator = findViewById(R.id.btnAdd);
        btnHitung = findViewById(R.id.btnHitung);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int angka1 = Integer.parseInt(text_1.getText().toString());
               int angka2 = Integer.parseInt(text_2.getText().toString());
               int hasil = 0;
               String text = spOperator.getSelectedItem().toString();
                switch (text){
                    case "Tambah":
                        hasil = angka1 + angka2;
                        tvHasil.setText(hasil+"");
                        break;

                        case "Kurang":
                        hasil = angka1 - angka2;
                        tvHasil.setText(hasil+"");
                        break;

                        case "Kali":
                        hasil = angka1 * angka2;
                        tvHasil.setText(hasil+"");
                        break;

                        case "Bagi":
                        double angka1Double = Double.parseDouble(text_1.getText().toString());
                        double angka2Double = Double.parseDouble(text_2.getText().toString());
                        double hasilDouble = angka1Double / angka2Double;
                        tvHasil.setText(hasilDouble + "");
                        break;
                }

            }
        });
    }
}