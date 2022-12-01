package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.adapter.SpinnerAdapter;
import com.example.myapplication.database.FeedReaderContract;
import com.example.myapplication.database.FeedReaderDBHelper;
import com.google.android.material.slider.Slider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] pcty = {
            "Intel Core i5t 12400 6 X 2,4 GHz 16GB DDR4 SSD 250GB M.2 + HDD 1TB Sata 1050 Ti 4GB, informatyk mówił że bestia cena 6000zł",
            "Intel Core i7 11700 8 x 2,9 GHz 16GB DDR4 SSD 500GB M.2 + GTX 1660 6GB, cena 5800zł",
            "Ryzen 3 3100 4 x 3.9 GHz 16GB DDR4 SSD 120GB + HDD 1TB Sata + RX 570 8GB, cena 4500zł"
    };

    int[] zdjeciaPcty = {
            R.drawable.i5,
            R.drawable.i7,
            R.drawable.spc
    };

    String[] myszki = {
            "Logitech G102 LIGHTSYNC, cena 110zł",
            "SPC Gear LIX, cena 120zł",
            "Genesis Xenon 750, cena 150zł"
    };

    int[] zdjeciaMyszki = {
            R.drawable.mysz1,
            R.drawable.mysz2,
            R.drawable.mysz3
    };

    String[] klawy = {
            "GK550 Omnis Kailh Brown RGB, cena 300zł",
            "GK650K Omnis Kailh Brown RGB, cena 330zł",
            "GK630K Tournament Kailh Brown RGB Onyx White, cena 200zł"
    };

    int[] zdjeciaKlawy = {
            R.drawable.klawa1,
            R.drawable.klawa2,
            R.drawable.klawa3
    };

    String[] sluchawki = {
            "SPC GEAR Viro Plus, cena 200zł",
            "SPC Gear VIRO 101M, cena 50zł",
            "Logitech G733 LIGHTSPEED lilac, cena 550zł"
    };

    int[] zdjeciaSluchawki = {
            R.drawable.sluchawki1,
            R.drawable.sluchawki2,
            R.drawable.sluchawki3
    };

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;

    int cenaM = 0;
    int cenaD1 = 0;
    int cenaD2 = 0;
    int cenaD3 = 0;
    int ilosc = 1;

    TextView cenaR;

    CheckBox dodatek1;
    CheckBox dodatek2;
    CheckBox dodatek3;

    Slider slider;

    String zamowienie;

    EditText klient;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(getApplicationContext(), zdjeciaPcty, pcty);
        spinner1.setAdapter(spinnerAdapter1);

        spinner2 = findViewById(R.id.spinner2);
        SpinnerAdapter spinnerAdapter2 = new SpinnerAdapter(getApplicationContext(), zdjeciaMyszki, myszki);
        spinner2.setAdapter(spinnerAdapter2);

        spinner3 = findViewById(R.id.spinner3);
        SpinnerAdapter spinnerAdapter3 = new SpinnerAdapter(getApplicationContext(), zdjeciaKlawy, klawy);
        spinner3.setAdapter(spinnerAdapter3);

        spinner4 = findViewById(R.id.spinner4);
        SpinnerAdapter spinnerAdapter4 = new SpinnerAdapter(getApplicationContext(), zdjeciaSluchawki, sluchawki);
        spinner4.setAdapter(spinnerAdapter4);

        cenaR = findViewById(R.id.cenaR);

        slider = findViewById(R.id.iloscS);

        dodatek1 = findViewById(R.id.dodatek1);
        dodatek2 = findViewById(R.id.dodatek2);
        dodatek3 = findViewById(R.id.dodatek3);

        klient = findViewById(R.id.dane);

        FeedReaderDBHelper dbHelper = new FeedReaderDBHelper(getApplicationContext());

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        cenaM = 6000;
                        break;

                    case 1:
                        cenaM = 5800;
                        break;

                    case 2:
                        cenaM = 4500;
                        break;

                }

                cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dodatek1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!dodatek1.isChecked()) {
                            cenaD1 = 0;
                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                        }

                        if (dodatek1.isChecked()) {

                            switch (i) {
                                case 0:
                                    cenaD1 = 110;
                                    break;

                                case 1:
                                    cenaD1 = 120;
                                    break;

                                case 2:
                                    cenaD1 = 150;
                                    break;
                            }

                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));

                        }

                    }
                });
                if (dodatek1.isChecked()) {

                    switch (i) {
                        case 0:
                            cenaD1 = 110;
                            break;

                        case 1:
                            cenaD1 = 120;
                            break;

                        case 2:
                            cenaD1 = 150;
                            break;
                    }

                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));

                }
                if (!dodatek1.isChecked()) {
                    cenaD1 = 0;
                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dodatek2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!dodatek2.isChecked()){
                            cenaD2 = 0;
                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                        }

                        if (dodatek2.isChecked()){
                            switch (i) {
                                case 0:
                                    cenaD2 = 300;
                                    break;

                                case 1:
                                    cenaD2 = 330;
                                    break;

                                case 2:
                                    cenaD2 = 200;
                                    break;
                            }

                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                        }

                    }
                });

                if (dodatek2.isChecked()){
                    switch (i) {
                        case 0:
                            cenaD2 = 300;
                            break;

                        case 1:
                            cenaD2 = 330;
                            break;

                        case 2:
                            cenaD2 = 200;
                            break;
                    }

                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                }

                if (!dodatek2.isChecked()) {
                    cenaD2 = 0;
                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dodatek3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!dodatek3.isChecked()){
                            cenaD3 = 0;
                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                        }

                        if (dodatek3.isChecked()){
                            switch (i) {
                                case 0:
                                    cenaD3 = 200;
                                    break;

                                case 1:
                                    cenaD3 = 50;
                                    break;

                                case 2:
                                    cenaD3 = 550;
                                    break;
                            }

                            cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                        }

                    }
                });

                if (dodatek3.isChecked()){
                    switch (i) {
                        case 0:
                            cenaD3 = 200;
                            break;

                        case 1:
                            cenaD3 = 50;
                            break;

                        case 2:
                            cenaD3 = 550;
                            break;
                    }

                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                }

                if (!dodatek3.isChecked()) {
                    cenaD3 = 0;
                    cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        slider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                ilosc = (int) slider.getValue();

                cenaR.setText(String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
            }
        });

        btn = findViewById(R.id.order);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pct = pcty[spinner1.getSelectedItemPosition()];
                String myszka = "";
                if (dodatek1.isChecked()){
                    myszka = myszki[spinner2.getSelectedItemPosition()];
                }

                String klawa = "";
                if (dodatek2.isChecked()){
                    klawa = klawy[spinner3.getSelectedItemPosition()];
                }

                String sluchawka = "";
                if (dodatek3.isChecked()){
                    sluchawka = sluchawki[spinner4.getSelectedItemPosition()];
                }

                if (klient.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Puste dane" , Toast.LENGTH_SHORT).show();
                }
                else {
                    zamowienie = pct + ", " + myszka + ", " + klawa + ", " + sluchawka;
                    SQLiteDatabase dbw = dbHelper.getWritableDatabase();

                    Date c = new Date();

                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss", Locale.getDefault());
                    String formatDate = df.format(c);

                    ContentValues values = new ContentValues();
                    values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, zamowienie);
                    values.put(FeedReaderContract.FeedEntry.ILOSC, String.valueOf(ilosc));
                    values.put(FeedReaderContract.FeedEntry.CENA, String.valueOf((cenaM + cenaD1 + cenaD2 + cenaD3) * ilosc));
                    values.put(FeedReaderContract.FeedEntry.CLIENT, klient.getText().toString());
                    values.put(FeedReaderContract.FeedEntry.DATE, formatDate);

                    long newRowId = dbw.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

                    recreate();

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.lista_zamowien:
                Intent intent = new Intent(this, ListaZamowien.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                this.startActivity(intent);
                return true;


            case R.id.wyslij_sms:
                Intent intent1 = new Intent(this, SendSms.class);

                String pct = pcty[spinner1.getSelectedItemPosition()];
                String myszka = "";
                if (dodatek1.isChecked()){
                    myszka = myszki[spinner2.getSelectedItemPosition()];
                }

                String klawa = "";
                if (dodatek2.isChecked()){
                    klawa = klawy[spinner3.getSelectedItemPosition()];
                }

                String sluchawka = "";
                if (dodatek3.isChecked()){
                    sluchawka = sluchawki[spinner4.getSelectedItemPosition()];
                }

                intent1.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                intent1.putExtra("key", pct + ", " + myszka + ", " + klawa + ", " + sluchawka);
                this.startActivity(intent1);


            case R.id.info:
                Intent intent2 = new Intent()


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}