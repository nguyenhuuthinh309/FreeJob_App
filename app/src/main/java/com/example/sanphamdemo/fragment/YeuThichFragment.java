package com.example.sanphamdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sanphamdemo.R;


public class YeuThichFragment extends Fragment {


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
}