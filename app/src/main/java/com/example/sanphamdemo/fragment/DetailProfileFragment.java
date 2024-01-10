package com.example.sanphamdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanphamdemo.R;


public class DetailProfileFragment extends Fragment {



    public DetailProfileFragment() {
        // Required empty public constructor
    }

    public static DetailProfileFragment newInstance() {
        DetailProfileFragment fragment = new DetailProfileFragment();

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
        return inflater.inflate(R.layout.fragment_detail_profile, container, false);
    }

}