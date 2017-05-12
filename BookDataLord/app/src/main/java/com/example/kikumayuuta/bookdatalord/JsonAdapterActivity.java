package com.example.kikumayuuta.bookdatalord;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kikumayuuta on 2017/05/12.
 */

public class JsonAdapterActivity extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<String> datas;
    private ArrayList<String> ids;
    private ArrayList<String> titles;
    private Context context;

    public Context getContext() {
        return context;
    }


    static class ViewHolder {
        TextView datatv;
        TextView icontv;
        TextView titletv;
    }

    public JsonAdapterActivity(Context context, int itemLayoutId, ArrayList icondata, ArrayList iconid , ArrayList icontitle) {

        inflater = LayoutInflater.from(context);
        datas = icondata;
        ids = iconid;
        titles = icontitle;

    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            Log.d("convertView == null()", "position= " + position);
            convertView = inflater.inflate(R.layout.test_list_data, null);
            holder = new ViewHolder();
            holder.datatv = (TextView)  convertView.findViewById(R.id.item_main);
            holder.icontv = (TextView) convertView.findViewById(R.id.item_sub);
            holder.titletv = (TextView) convertView.findViewById(R.id.item_right);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.datatv.setText(datas.get(position));
        holder.icontv.setText(String.valueOf(position+1) + " : " + ids.get(position));
        holder.titletv.setText(String.valueOf(position+1) + " : " + titles.get(position));

        return convertView;


    }
}
