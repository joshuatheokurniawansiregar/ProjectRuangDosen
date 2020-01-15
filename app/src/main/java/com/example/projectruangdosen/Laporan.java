package com.example.projectruangdosen;

public class Laporan {
    private String email;
    private String benar;
    private String  salah;
    private String totalNila;

    public Laporan(String email, String benar, String salah, String totalNila) {
        this.email = email;
        this.benar = benar;
        this.salah = salah;
        this.totalNila = totalNila;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Laporan() {
    }

    public String getBenar() {
        return benar;
    }

    public void setBenar(String benar) {
        this.benar = benar;
    }

    public String getSalah() {
        return salah;
    }

    public void setSalah(String salah) {
        this.salah = salah;
    }

    public String getTotalNila() {
        return totalNila;
    }

    public void setTotalNila(String totalNila) {
        this.totalNila = totalNila;
    }
}
