package com.example.sanphamdemo.user;

public class UserItem {
 private  String tenban;

 private String thoigian;
    private String giatien;
    private Boolean trangthai;
    public UserItem() {
    }



    public UserItem(String tenban, String thoigian, String giatien, Boolean trangthai) {
        this.tenban = tenban;
        this.thoigian = thoigian;
        this.giatien = giatien;
        this.trangthai = trangthai;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}
