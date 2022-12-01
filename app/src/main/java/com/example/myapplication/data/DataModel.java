package com.example.myapplication.data;

public class DataModel {
    String zamowienie;
    String ilosc;
    String cena;
    String client;
    String data;

    public DataModel(String zamowienie, String ilosc, String cena, String client, String data) {
        this.zamowienie = zamowienie;
        this.ilosc = ilosc;
        this.cena = cena;
        this.client = client;
        this.data = data;
    }

    public String getZamowienie() {
        return zamowienie;
    }

    public String getIlosc() {
        return ilosc;
    }

    public String getCena() {
        return cena;
    }

    public String getClient() {
        return client;
    }

    public String getData() {
        return data;
    }
}
