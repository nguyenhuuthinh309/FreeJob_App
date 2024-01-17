package com.example.sanphamdemo.user;

public class ServerResponse {
    private String message;
    private String requestId;  // Giả sử có một thuộc tính requestId

    private String trangthai;
    private String tencongty,giatien;
    private String idUngVien;

    public String getIdUngVien() {
        return idUngVien;
    }

    public void setIdUngVien(String idUngVien) {
        this.idUngVien = idUngVien;
    }

    public String getTencongty() {
        return tencongty;
    }

    public String getGiatien() {
        return giatien;
    }

// Constructor, getter và setter

    public String getTrangthai() {
        return trangthai;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getMessage() {
        return message;
    }
}