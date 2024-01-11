package com.example.sanphamdemo.user;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ban_User implements Serializable {
    private int id;
 //   @SerializedName("ten")
    private String ten;
    @SerializedName("giovao")
    private String giovao;
  //  @SerializedName("gia")
    private int gia;
 ///  @SerializedName("trangthai")
    private int trangthai;
 //   @SerializedName("ngaythang")
    private String ngaythang;

    String ngaytao;

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Ban_User() {
    }

    public Ban_User(String giovao) {
        this.giovao = giovao;
    }

    public Ban_User(String ten, String giovao, int gia, int trangthai, String ngaythang) {
        this.ten = ten;
        this.giovao = giovao;
        this.gia = gia;
        this.trangthai = trangthai;
        this.ngaythang = ngaythang;
    }

    public Ban_User(int id, String ten, String giovao, int gia, int trangthai, String ngaythang) {
        this.id = id;
        this.ten = ten;
        this.giovao = giovao;
        this.gia = gia;
        this.trangthai = trangthai;
        this.ngaythang = ngaythang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiovao() {
        return giovao;
    }

    public void setGiovao(String giovao) {
        this.giovao = giovao;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(String ngaythang) {
        this.ngaythang = ngaythang;
    }
}
