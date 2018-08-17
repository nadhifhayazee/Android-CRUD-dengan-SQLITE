package com.example.abdullah.crudsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {

    private DatabaseHandler db;
    private String Sid, Snama, Snrp;
    private EditText Enama, Enrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);

        db = new DatabaseHandler(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Snrp = i.getStringExtra("Inrp");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Enrp = (EditText) findViewById(R.id.updel_nrp);

        Enama.setText(Snama);
        Enrp.setText(Snrp);

        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Snrp = String.valueOf(Enrp.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Snrp.equals("")){
                    Enrp.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi NRP", Toast.LENGTH_SHORT).show();
                } else{
                    db.updateMahasiswa(new ModalMahasiswa(Sid, Snama, Snrp));
                    Toast.makeText(MainUpdel.this, "Data berhasil di update", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteMahasiswa(new ModalMahasiswa(Sid, Snama, Snrp));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
