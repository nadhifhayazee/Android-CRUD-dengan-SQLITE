package com.example.abdullah.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kampus";

    private static final String tb_mahasiswa = "tb_mahasiswa";

    private static final String tb_mhs_id = "id";
    private static final String tb_mhs_nama = "nama";
    private static final String tb_mhs_nrp = "nrp";

    //membuat database

    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE " + tb_mahasiswa + "("
            + tb_mhs_id + " INTEGER PRIMARY KEY ,"
            + tb_mhs_nama + " TEXT,"
            + tb_mhs_nrp + " TEXT " + ")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAHASISWA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void createMahasiswa(ModalMahasiswa dataMhs){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mhs_id, dataMhs.getId());
        values.put(tb_mhs_nama, dataMhs.getNama());
        values.put(tb_mhs_nrp, dataMhs.getNrp());
        db.insert(tb_mahasiswa, null, values);
        db.close();
    }

    public List<ModalMahasiswa> ReadMahasiswa(){
        List<ModalMahasiswa> judulModelList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tb_mahasiswa;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                ModalMahasiswa mdKontak = new ModalMahasiswa();
                mdKontak.setId(cursor.getString(0));
                mdKontak.setNama(cursor.getString(1));
                mdKontak.setNrp(cursor.getString(2));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int updateMahasiswa(ModalMahasiswa mdNotif){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_mhs_nama, mdNotif.getNama());
        values.put(tb_mhs_nrp, mdNotif.getNrp());

        return db.update(tb_mahasiswa, values, tb_mhs_id + " = ?",
                new String[] { String.valueOf(mdNotif.getId())});
    }

    public void deleteMahasiswa(ModalMahasiswa mdNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mahasiswa, tb_mhs_id+ " = ?",
                new String[]{String.valueOf(mdNotif.getId())});
        db.close();
    }


}
