package com.example.abdullah.crudsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {

    private DatabaseHandler db;
    private EditText Enama, Enrp;
    private String Snama, Snrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        Enama = (EditText) findViewById(R.id.etBuatNama);
        Enrp = (EditText) findViewById(R.id.etBuatNrp);

        Button btnBuat = (Button) findViewById(R.id.btnBuat);
        btnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Snrp = String.valueOf(Enrp.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Masukkan Nama", Toast.LENGTH_SHORT).show();
                } else if (Snrp.equals("")){
                    Enrp.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Masukkan NRP", Toast.LENGTH_SHORT).show();
                } else{
                    Enama.setText("");
                    Enrp.setText("");
                    Toast.makeText(MainCreate.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                    db.createMahasiswa(new ModalMahasiswa(null, Snama, Snrp));
                }
            }
        });
    }
}
