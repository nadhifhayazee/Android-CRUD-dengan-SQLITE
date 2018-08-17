package com.example.abdullah.crudsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private CustomListAdaptor adaptor_off;
    private DatabaseHandler db;
    private List<ModalMahasiswa> listMahasiswa = new ArrayList<ModalMahasiswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        db = new DatabaseHandler(this);

        adaptor_off = new CustomListAdaptor(this, listMahasiswa);
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adaptor_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listMahasiswa.clear();

        List<ModalMahasiswa> contacts = db.ReadMahasiswa();
        for (ModalMahasiswa cn : contacts){
            ModalMahasiswa judulModel = new ModalMahasiswa();
            judulModel.setId(cn.getId());
            judulModel.setNama(cn.getNama());
            judulModel.setNrp(cn.getNrp());
            listMahasiswa.add(judulModel);

            if ((listMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        ModalMahasiswa obj_itemDetail = (ModalMahasiswa)o;

        String Sid = obj_itemDetail.getId();
        String Snama = obj_itemDetail.getNama();
        String Snrp = obj_itemDetail.getNrp();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Inrp", Snrp);
        startActivity(goUpdel);

    }

    @Override
    protected void onResume() {
        super.onResume();
        listMahasiswa.clear();
        mListView.setAdapter(adaptor_off);
        List<ModalMahasiswa> contacts = db.ReadMahasiswa();
        for (ModalMahasiswa cn : contacts){
            ModalMahasiswa judulModel = new ModalMahasiswa();
            judulModel.setId(cn.getId());
            judulModel.setNama(cn.getNama());
            judulModel.setNrp(cn.getNrp());
            listMahasiswa.add(judulModel);

            if ((listMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();

        }
    }
}
