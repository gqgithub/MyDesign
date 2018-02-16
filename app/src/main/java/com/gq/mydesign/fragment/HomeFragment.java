package com.gq.mydesign.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gq.mydesign.Constants;
import com.gq.mydesign.R;

/**
 * Created by Administrator on 2018/2/11.
 */
public class HomeFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
        textView.setText("Home");
        return view;
    }

    public static HomeFragment newInstance(String home) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS,home);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

}
