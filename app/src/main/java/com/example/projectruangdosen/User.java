package com.example.projectruangdosen;

public class User {


    private String name;
    private String email;
    private String password;
    private String tanggallahir;
    private String notelp;
    private String key;

    public User() {
    }

    public User(String name, String email, String password, String tanggallahir, String notelp) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tanggallahir = tanggallahir;
        this.notelp = notelp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
