package com.example.sanphamdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sanphamdemo.R;

public class UngTuyenFragment extends Fragment {



    public UngTuyenFragment() {
        // Required empty public constructor
    }


    public static UngTuyenFragment newInstance() {
        UngTuyenFragment fragment = new UngTuyenFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_khach_dat_lich, container, false);
    }
}