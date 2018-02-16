package com.gq.mydesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */
public class MainAdapter extends RecyclerView.Adapter{

    private List<String> mList;
    private Context mContext;

    public MainAdapter(Context mContext,List<String> list){
        this.mContext=mContext;
        mList=list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_main_adapter,parent,false);
        return new FavHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FavHolder favHolder = (FavHolder) holder;
        favHolder.bindItem(mList.get(position));
        Log.e("gang","viewholder"+mList.get(position));
    }

    @Override
    public int getItemCount() {
        return  mList == null ? 0:mList.size();
    }

    public class FavHolder extends RecyclerView.ViewHolder{
        TextView tvname;


        public FavHolder(View itemView) {
            super(itemView);

            tvname = (TextView) itemView.findViewById(R.id.item_main_tv_name);
        }

        public void bindItem(final String essay) {
            tvname.setText(essay);

            tvname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //3.调用接口
                    mIMain.tianzhuan(essay);
                }
            });
        }

    }

    //1.创建接口类
    IMain mIMain;

    public interface IMain {
        void tianzhuan(String str);
    }

    //2.注册函数
    public void setOnClickMyTextView(IMain iMain){
        this.mIMain = iMain;
    }


}