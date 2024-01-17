package com.example.sanphamdemo.interfaceall;

import com.example.sanphamdemo.user.HoaDonCongTyy;

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
            @Field("thanhTien") String thanhTien,
            @Field("ngaytao")String ngaytao);

    @FormUrlEncoded
    @POST("/api/updatetrangthaihoadon/:idHoaDonCongTy")
    Call<HoaDonCongTyy> update1(@Field("idHoaDonCongTy") int idHoaDonCongTy );


    @FormUrlEncoded
    @POST("deletehd/:id")
    Call<HoaDonCongTyy> deletecongty(@Field("idHoaDonCongTy") int idHoaDonCongTy );

    @FormUrlEncoded
    @POST("suaprofilecongty")
    Call<HoaDonCongTyy> updatethongtincongty(

            @Field("idHoaDonCongTy") int idHoaDonCongTy,
            @Field("diaChi") String diachi,
            @Field("linhVuc") String linhvuc);


}
