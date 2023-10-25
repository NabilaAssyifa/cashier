package com.smk.casier.model;

public class Stok extends Model {
    private int id;
    private String kodeBarang;
    private String namaBarang;
    private int stokId;
    private char stokBarang;

    private int jumlahStok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setStokId(String i) {
        this.id = id;

    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;

    }

    public void setJumlahStok(int jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public int getStokId() {
        return stokId;
    }


    public String getNamaBarang() {
        return  namaBarang;
    }


    public int getJumlahStok() {
        return jumlahStok;
    }

}
