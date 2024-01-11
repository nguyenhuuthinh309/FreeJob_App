package com.example.sanphamdemo.interfaceall;

import com.example.sanphamdemo.user.RequestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface_getlistYeuCau {
    @GET("api/getListyeucau")
    Call<List<RequestModel>> getListYeuCau();
}
