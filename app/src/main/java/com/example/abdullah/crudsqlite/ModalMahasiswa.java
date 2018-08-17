package com.example.abdullah.crudsqlite;

public class ModalMahasiswa {

    private String id, nama, nrp;

    public ModalMahasiswa(String id, String nama, String nrp) {
        this.id = id;
        this.nama = nama;
        this.nrp = nrp;
    }

    public ModalMahasiswa() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNrp() {
        return nrp;
    }
}
