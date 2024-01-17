package com.example.sanphamdemo.user;

import java.io.Serializable;

public class  RequestModel implements Serializable {
    private String requestId;
    private String message;
    private  String idUngVien;
    private String tencongty;
    private String giatien;

    private boolean isConfirmed;



    public RequestModel(String requestId, String message, boolean isConfirmed) {
        this.requestId = requestId;
        this.message = message;
        this.isConfirmed = isConfirmed;

    }

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

    public String getRequestId() {
        return requestId;
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


}
