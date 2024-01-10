package com.example.sanphamdemo.hoadoncongty;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Interface_HoaDonCongTy {


    @FormUrlEncoded
    @POST("addhoadoncongty")
    Call<HoaDonCongTyy> adDHoadonCongTy(
            @Field("idHoaDonCongTy") int idHoaDonCongTy,
            @Field("idUngVien") String idUngVien,
            @Field("tenCongTy") String tenCongTy,
            @Field("diaChi") String diaChi,
            @Field("linhVuc") String linhVuc,
            @Field("kiHan") String kiHan,
           @Field("trangThai") String trangThai,
            @Field("thanhTien") String thanhTien);



}
