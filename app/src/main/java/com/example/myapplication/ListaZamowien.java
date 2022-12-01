package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adapter.CustomAdapter;
import com.example.myapplication.data.DataModel;
import com.example.myapplication.database.FeedReaderDBHelper;

import java.util.ArrayList;

public class ListaZamowien extends AppCompatActivity {

    ListView listView;
    ArrayList list;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_zamowien);

        listView = findViewById(R.id.listView);

        FeedReaderDBHelper dbHelper = new FeedReaderDBHelper(getApplicationContext());

        SQLiteDatabase dbr = dbHelper.getReadableDatabase();

        list = new ArrayList<>();

        Cursor cursor = dbr.rawQuery("SELECT * FROM ZAMOWIENIA", null);

        while (cursor.moveToNext()) {
            list.add(new DataModel(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
        }

        adapter = new CustomAdapter(list, getApplicationContext());

        if(list.size() != 0){
            listView.setAdapter(adapter);
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("dodaj kontakty do swojej listy wykorzystując menu").setTitle("Brak kontaktów");

            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }
}