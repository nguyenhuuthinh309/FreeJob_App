package com.example.sanphamdemo.interfaceall;

import com.example.sanphamdemo.user.ConfirmationRequest;
import com.example.sanphamdemo.user.RequestModel;
import com.example.sanphamdemo.user.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Interface_AddYeucau {
    @POST("confirmRequest")
    Call<RequestModel> confirmRequest(@Body ConfirmationRequest confirmationRequest);
    @FormUrlEncoded
    @POST("addyeucau")
    Call<ServerResponse> addYeuCau(@Field("requestId") String requestId,

                                   @Field("trangthai") String trangthai,
                                   @Field("idUngVien") String idUngVien,
                                   @Field("tencongty") String tencongty,@Field("giatien") String giatien);
}

