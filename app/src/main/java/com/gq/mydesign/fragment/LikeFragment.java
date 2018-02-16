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
 * Created by Kevin on 2016/11/28.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class LikeFragment extends Fragment{

    public static LikeFragment newInstance(String s){
        LikeFragment homeFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS,s);
        homeFragment.setArguments(bundle);
        return homeFragment;
}

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.ARGS);
        TextView textView = (TextView) view.findViewById(R.id.tv_like);
        textView.setText("like");
        return view;
    }
}
