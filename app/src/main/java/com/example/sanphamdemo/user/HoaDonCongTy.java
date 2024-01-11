package com.example.sanphamdemo.user;

import java.util.ArrayList;

public class HoaDonCongTy extends ArrayList<HoaDonCongTy> {
    int idHoaDonCongTy;
    String idUngVien,tenCongTy,diaChi,linhVuc,kiHan,trangThai,thanhTien;
    private String message;
    private boolean isConfirmed;
    private boolean isAccepted;


    public HoaDonCongTy(int idHoaDonCongTy, String message, boolean isConfirmed) {
        this.idHoaDonCongTy = idHoaDonCongTy;
        this.message = message;
        this.isConfirmed = isConfirmed;
    }
    public HoaDonCongTy( int idHoaDonCongTy, boolean isAccepted) {
        this.idHoaDonCongTy = idHoaDonCongTy;
        this.isAccepted = isAccepted;
    }

    public String getMessage() {
        return message;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }


    public HoaDonCongTy(int idHoaDonCongTy, String idUngVien, String tenCongTy, String diaChi, String linhVuc, String kiHan, String trangThai, String thanhTien) {
        this.idHoaDonCongTy = idHoaDonCongTy;
        this.idUngVien = idUngVien;
        this.tenCongTy = tenCongTy;
        this.diaChi = diaChi;
        this.linhVuc = linhVuc;
        this.kiHan = kiHan;
        this.trangThai = trangThai;
        this.thanhTien = thanhTien;
    }

    public int getIdHoaDonCongTy() {
        return idHoaDonCongTy;
    }

    public void setIdHoaDonCongTy(int idHoaDonCongTy) {
        this.idHoaDonCongTy = idHoaDonCongTy;
    }

    public String getIdUngVien() {
        return idUngVien;
    }

    public void setIdUngVien(String idUngVien) {
        this.idUngVien = idUngVien;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }
}
