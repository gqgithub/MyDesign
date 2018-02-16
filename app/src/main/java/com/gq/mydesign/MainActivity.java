package com.gq.mydesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.IMain {
    List<String> mActivity;
    RecyclerView mRecyclerView;
    MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置为listview的布局
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new MainAdapter(this,mActivity);
        //4.初始化接口
        mAdapter.setOnClickMyTextView(this);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mActivity=new ArrayList<>();
        mActivity.add("ToolBarActivity");
        mActivity.add("BottomNavigationBarActivity");
        mActivity.add("SnackBarActivity");


    }


    //4.implements MainAdapter.IMain
    @Override
    public void tianzhuan(String str) {
        Intent intent;
        if (str.equals("ToolBarActivity")){
            intent=new Intent(this, ToolBarActivity.class);
            startActivity(intent);
        }else if(str.equals("BottomNavigationBarActivity")){
            intent=new Intent(this, BottomNavigationBarActivity.class);
            startActivity(intent);
        }

    }
    
}
