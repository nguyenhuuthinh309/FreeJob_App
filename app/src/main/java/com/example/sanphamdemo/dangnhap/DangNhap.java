package com.example.sanphamdemo.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.activity.Home;
import com.example.sanphamdemo.interfaceall.Interface_UngVien;
import com.example.sanphamdemo.user.UngVienResponse;
import com.example.sanphamdemo.user.UngVien;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DangNhap extends AppCompatActivity {
    ProgressDialog progressDialog;
    private EditText email;
    private EditText matkhau;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView tvChinhSachBaoMat;
    private TextView textView8;
    private TextView tvBtnDangKy;
    private CheckBox rememberMeCheckBox;

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_EMAIL = "email";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_REMEMBER_ME = "rememberMe";
   List<UngVienResponse> list ;

    UngVien ungVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        email = (EditText) findViewById(R.id.email1);
        matkhau = (EditText) findViewById(R.id.matkhau1);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        tvChinhSachBaoMat = (TextView) findViewById(R.id.tv_ChinhSachBaoMat);
        textView8 = (TextView) findViewById(R.id.textView8);
        tvBtnDangKy = (TextView) findViewById(R.id.tv_Btn_DangKy);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Vui lòng chờ...");
        rememberMeCheckBox = findViewById(R.id.checkboxRememberPassword);
        list = new ArrayList<>();

        // Load trạng thái "Nhớ mật khẩu" từ SharedPreferences
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean rememberMe = preferences.getBoolean(PREF_REMEMBER_ME, false);
        rememberMeCheckBox.setChecked(rememberMe);

        if (rememberMe) {
            // Nếu "Nhớ mật khẩu" đã chọn, load thông tin mật khẩu từ SharedPreferences
            String savedEmail = preferences.getString(PREF_EMAIL, "");
            String savedPassword = preferences.getString(PREF_PASSWORD, "");

            // Đặt giá trị vào EditText
            email.setText(savedEmail);
            matkhau.setText(savedPassword);
        }

        rememberMeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Lưu trạng thái "Nhớ mật khẩu" vào SharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
                editor.putBoolean(PREF_REMEMBER_ME, isChecked);
                editor.apply();
            }
        });



        tvBtnDangKy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressDialog.show();
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://192.168.1.6:3000/")
                                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                                .build();
                        String emailn = email.getText().toString();
                        String matkhaun = matkhau.getText().toString();
                        Interface_UngVien interfaceDelete = retrofit.create(Interface_UngVien.class);
                        Call<UngVienResponse> call = interfaceDelete.getListUngvien(emailn,matkhaun);
                        call.enqueue(new Callback<UngVienResponse>() {
                            @Override
                            public void onResponse(Call<UngVienResponse> call, Response<UngVienResponse> response) {
                                if (response.isSuccessful() && response.body() != null) {
                                    progressDialog.dismiss();
                                    UngVienResponse ungVienResponse = response.body();
                                    UngVien ungVien = ungVienResponse.getUngVien();

                                    // Trong sự kiện đăng nhập


// Kiểm tra xem "Nhớ mật khẩu" có được chọn không
                                    if (rememberMeCheckBox.isChecked()) {
                                        // Lưu thông tin mật khẩu vào SharedPreferences
                                        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
                                        editor.putString(PREF_EMAIL, emailn);
                                        editor.putString(PREF_PASSWORD, matkhaun);
                                        editor.apply();
                                    } else {
                                        // Nếu "Nhớ mật khẩu" không được chọn, xóa thông tin mật khẩu từ SharedPreferences
                                        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
                                        editor.remove(PREF_EMAIL);
                                        editor.remove(PREF_PASSWORD);
                                        editor.apply();
                                    }


                                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putInt("user_id", ungVien.getIdUngVien());
                                    editor.putString("user_email", ungVien.getEmail());
                                    editor.putString("user_matkhau", ungVien.getMatkhau());
                                    editor.apply();
                                    Intent intent = new Intent(DangNhap.this, Home.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable("objungvien",ungVien);
                                    intent.putExtras(bundle);
                                    startActivity(intent);

                                    Toast.makeText(DangNhap.this, ungVien.getHoten(), Toast.LENGTH_SHORT).show();

                                    // Tiếp tục với các hành động khác sau khi đăng nhập thành công
                                } else if (response.code() == 401) {
                                    // Xử lý khi đăng nhập thất bại
                                    progressDialog.dismiss();
                                    Toast.makeText(DangNhap.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                                } else {
                                    progressDialog.dismiss();
                                    // Xử lý khi có lỗi khác
                                    try {
                                        progressDialog.dismiss();
                                        String errorBody = response.errorBody().string();

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<UngVienResponse> call, Throwable t) {
                                progressDialog.dismiss();
                                // Xử lý khi có lỗi kết nối
                                Toast.makeText(DangNhap.this, "Lỗi kết nối Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.d("zzzzzzzz", t.getMessage());
                                finish();
                            }
                        });
                    }
                });




            }



}