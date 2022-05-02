package com.example.appbandt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbandt.R;
import com.example.appbandt.model.Monan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MonanAdapter extends BaseAdapter {
    ArrayList<Monan> arrayListmonan;
    Context context;

    public MonanAdapter(ArrayList<Monan> arrayListmonan, Context context) {
        this.arrayListmonan = arrayListmonan;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListmonan.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListmonan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        TextView txttenmonan;
        ImageView imgmonan;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_monan,null);
            viewHolder.txttenmonan = view.findViewById(R.id.txtmonan);
            viewHolder.imgmonan = view.findViewById(R.id.imgviewmonan);
            view.setTag(viewHolder);
            viewHolder = (ViewHolder) view.getTag();
            Monan monan = (Monan) getItem(i);
            viewHolder.txttenmonan.setText(monan.getTenmonan());
            Picasso.get().load(monan.getHinhmonan())
                    .into(viewHolder.imgmonan);
        return view;
    }

}
