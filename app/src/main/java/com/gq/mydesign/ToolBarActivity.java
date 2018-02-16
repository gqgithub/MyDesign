package com.gq.mydesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * ToolBar的体验
 */
public class ToolBarActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        initToolBar();

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_share);
        toolbar.setLogo(android.R.drawable.ic_menu_edit);
//        toolbar.setTitle();
//        toolbar.setSubtitle();

        //action menu操作菜单按钮的点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.share:
                        Toast.makeText(ToolBarActivity.this, "分享", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(ToolBarActivity.this,"设置",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        //导航按钮的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
