package com.example.sanphamdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.adapter.MyAdapter;
import com.example.sanphamdemo.interfaceall.Interface_ListBan;
import com.example.sanphamdemo.user.Ban_User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class YeuThichFragment extends Fragment {
    TextView tvTitleViecGoiY;
    private RecyclerView recyclerListFavorites;
    RecyclerView recyclerView_ViecGoiY;
    RecyclerView.LayoutManager layoutManager_ViecGoiY;
    RecyclerView.LayoutManager layoutManager;
    // AdapterItem adapter1;
    private GridView gridView;
    private ArrayList<Ban_User> arrayList = new ArrayList<>();
    MyAdapter adapter1;


    public YeuThichFragment() {
        // Required empty public constructor
    }


    public static YeuThichFragment newInstance() {
        YeuThichFragment fragment = new YeuThichFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yeuthich, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerListFavorites = (RecyclerView) view.findViewById(R.id.recycler_list_favorites);

        adapter1 = new MyAdapter(getActivity());
        adapter1.setData(arrayList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerListFavorites.setLayoutManager(linearLayoutManager2);
        recyclerListFavorites.setAdapter(adapter1);
        loadbaidang();
    }
    private void loadbaidang() {
        // Tạo Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:3000/") // Điền địa chỉ cơ sở của API của bạn
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Tạo instance của ApiService từ Retrofit
        Interface_ListBan apiService = retrofit.create(Interface_ListBan.class);

        // Gọi API để lấy dữ liệu
        Call<List<Ban_User>> call = apiService.getListProduct1();
        call.enqueue(new Callback<List<Ban_User>>() {
            @Override
            public void onResponse(Call<List<Ban_User>> call, Response<List<Ban_User>> response) {
                // Xử lý dữ liệu khi nhận được
                List<Ban_User> responseData = response.body();

                // Cập nhật dataList và thông báo thay đổi trong Adapter
                arrayList.addAll(responseData);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Ban_User>> call, Throwable t) {
                // Xử lý khi có lỗi xảy ra
                Log.e("MainActivity", "Error: " + t.getMessage());
            }
        });
    }

}