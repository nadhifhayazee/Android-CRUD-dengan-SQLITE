package com.example.abdullah.crudsqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdaptor extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModalMahasiswa> mhs;

    public CustomListAdaptor(Activity activity, List<ModalMahasiswa> mhs) {
        this.activity = activity;
        this.mhs = mhs;
    }

    @Override
    public int getCount() {
        return mhs.size();
    }

    @Override
    public Object getItem(int i) {
        return mhs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = inflater.inflate(R.layout.costum_list, null);
        }

        TextView nama = (TextView) view.findViewById(R.id.text_nama);
        TextView nrp = (TextView) view.findViewById(R.id.text_nrp);

        ImageView imageView = (ImageView) view.findViewById(R.id.iconid);

        ModalMahasiswa m = mhs.get(i);

        nama.setText("NAMA : "+ m.getNama());
        nrp.setText("NRP : "+ m.getNrp());

        return view;

    }
}
