package com.example.appbandt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbandt.R;
import com.example.appbandt.model.Monan;
import com.example.appbandt.model.Nhahang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class NhahangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Nhahang> nhahangArrayList;

    public NhahangAdapter(Context context, ArrayList<Nhahang> nhahangArrayList) {
        this.context = context;
        this.nhahangArrayList = nhahangArrayList;
    }
    @Override
    public int getCount() {
        return nhahangArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return nhahangArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        ImageView imgnhahang;
        TextView txttennhahang,txtdiachi,txtgia,txtgiomocua,txtgiodongcua;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.dong_nhahang,null);
        viewHolder.imgnhahang = view.findViewById(R.id.imgnhahang);
        viewHolder.txttennhahang = view.findViewById(R.id.txttennhahang);
        viewHolder.txtdiachi = view.findViewById(R.id.txtdiachi);
        viewHolder.txtgia = view.findViewById(R.id.txtgia);
        viewHolder.txtgiomocua = view.findViewById(R.id.txtgiomocua);
        viewHolder.txtgiodongcua = view.findViewById(R.id.txtgiodongcua);
        view.setTag(viewHolder);
        viewHolder = (NhahangAdapter.ViewHolder) view.getTag();
        Nhahang nhahang = (Nhahang) getItem(i);
        viewHolder.txttennhahang.setText(nhahang.getTennhahang());
        Picasso.get().load(nhahang.getHinhanhnhahang())
                .into(viewHolder.imgnhahang);
        viewHolder.txtdiachi.setText(nhahang.getDiachinhahang());
        viewHolder.txtgia.setText("Gia: "+ nhahang.getGia()+" Dong");
        viewHolder.txtgiomocua.setText("Gio mo cua: "+nhahang.getGiomocua());
        viewHolder.txtgiodongcua.setText("Gio dong cua: "+nhahang.getGiodongcua());
        return view;
    }
}
