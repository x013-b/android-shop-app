package com.example.myapplication.database;

import android.provider.BaseColumns;

public class FeedReaderContract {

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "zamowienia";
        public static final String COLUMN_NAME_TITLE = "nazwa";
        public static final String ILOSC = "ilosc";
        public static final String CENA = "cena";
        public static final String CLIENT = "klient";
        public static final String DATE = "data";
        public static final String _ID = "_id";
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.ILOSC + " TEXT," +
                    FeedEntry.CENA + " TEXT," +
                    FeedEntry.CLIENT + " TEXT," +
                    FeedEntry.DATE + " TEXT)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
