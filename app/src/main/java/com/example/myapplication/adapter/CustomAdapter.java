package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.data.DataModel;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {
    private ArrayList<DataModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtZamowienie;
        TextView txtIlosc;
        TextView txtCena;
        TextView txtKlient;
        TextView txtData;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.list_view_items, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataModel dataModel = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_view_items, parent, false);
            viewHolder.txtZamowienie = convertView.findViewById(R.id.txtZamowienie);
            viewHolder.txtIlosc = convertView.findViewById(R.id.txtIlosc);
            viewHolder.txtCena = convertView.findViewById(R.id.txtCena);
            viewHolder.txtKlient = convertView.findViewById(R.id.txtKlient);
            viewHolder.txtData = convertView.findViewById(R.id.txtData);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtZamowienie.setText(dataModel.getZamowienie());
        viewHolder.txtIlosc.setText("Ilość: " + dataModel.getIlosc());
        viewHolder.txtCena.setText("Cena: " + dataModel.getCena());
        viewHolder.txtKlient.setText("Klient: " + dataModel.getClient());
        viewHolder.txtData.setText("Data: " + dataModel.getData());

        return convertView;
    }
}
