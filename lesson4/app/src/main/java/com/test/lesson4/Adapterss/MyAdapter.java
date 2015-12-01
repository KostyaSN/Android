package com.test.lesson4.Adapterss;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.lesson4.R;

import java.util.List;


public class MyAdapter extends BaseAdapter {


    private Context mContext;
    private List<String> mList;
    private LayoutInflater mlayoutInflater;

    public MyAdapter(Context context, List<String> list){
        mContext = context;
        mList = list;
        mlayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder {
        public TextView text;
    }

    @Override
    public int getCount() {
        Log.d(this.getClass().getSimpleName(),"getView position  =");

        return mList == null? 0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null? 0:mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
    if(view == null)
    {
        view = mlayoutInflater.inflate(R.layout.item_my, parent, false);

    Log.d(this.getClass().getSimpleName(), "getView position  =" + position);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.text = (TextView) view.findViewById(R.id.textView2);
        view.setTag(viewHolder);
    }

        ViewHolder holder = (ViewHolder) view.getTag();
        String s = mList.get(position);
        holder.text.setText(s);

        return view;
    }
}
