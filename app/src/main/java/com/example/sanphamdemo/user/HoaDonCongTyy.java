package com.example.sanphamdemo.user;

public class HoaDonCongTyy {

        private int idHoaDonCongTy;
        private String idUngVien, tenCongTy, diaChi, linhVuc, kiHan, trangThai, thanhTien;

        public HoaDonCongTyy(int idHoaDonCongTy, String idUngVien, String tenCongTy, String diaChi, String linhVuc, String kiHan, String trangThai, String thanhTien) {
            this.idHoaDonCongTy = idHoaDonCongTy;
            this.idUngVien = idUngVien;
            this.tenCongTy = tenCongTy;
            this.diaChi = diaChi;
            this.linhVuc = linhVuc;
            this.kiHan = kiHan;
            this.trangThai = trangThai;
            this.thanhTien = thanhTien;
        }

    public HoaDonCongTyy(int idHoaDonCongTy) {
        this.idHoaDonCongTy = idHoaDonCongTy;
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
    // Getters and setters...

//        // (Optional) You might want to override toString() for debugging purposes
//        @Override
//        public String toString() {
//            return "HoaDonCongTy{" +
//                    "idHoaDonCongTy=" + idHoaDonCongTy +
//                    ", idUngVien='" + idUngVien + '\'' +
//                    ", tenCongTy='" + tenCongTy + '\'' +
//                    ", diaChi='" + diaChi + '\'' +
//                    ", linhVuc='" + linhVuc + '\'' +
//                    ", kiHan='" + kiHan + '\'' +
//                    ", trangThai='" + trangThai + '\'' +
//                    ", thanhTien='" + thanhTien + '\'' +
//                    '}';
//        }
    }


