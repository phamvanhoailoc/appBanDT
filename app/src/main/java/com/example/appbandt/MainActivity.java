package com.example.appbandt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.appbandt.adapter.MonanAdapter;
import com.example.appbandt.adapter.NhahangAdapter;
import com.example.appbandt.model.Monan;
import com.example.appbandt.model.Nhahang;
import com.example.appbandt.retofit2.APIUtils;
import com.example.appbandt.retofit2.DataClient;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    ListView lvtrangchinh;
    NavigationView navigationView;
    ListView lvmanhinhchinh;
    DrawerLayout drawerLayout;
    String tenmonan ;
    String hinhmonan ;
    String tennhahang;
    String diachi;
    String hinhnhahang;
    Float gia;
    Time giomocua,giodongcua;
    MonanAdapter monanAdapter ;
    NhahangAdapter nhahangAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        actionbar();
        actionViewFlipper();
        getdulieumonan();
        getdulieunhahang();

    }

    private void getdulieunhahang() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Nhahang>> callback = dataClient.Dsnhahang(tennhahang,diachi,gia,giomocua,giodongcua,hinhnhahang);
        callback.enqueue(new Callback<List<Nhahang>>() {
            @Override
            public void onResponse(Call<List<Nhahang>> call, Response<List<Nhahang>> response) {
                ArrayList<Nhahang> nhahangs = (ArrayList<Nhahang>) response.body();
                nhahangAdapter = new NhahangAdapter(getApplicationContext(),nhahangs);
                lvtrangchinh.setAdapter(nhahangAdapter);
                nhahangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Nhahang>> call, Throwable t) {

            }
        });
    }

    private void getdulieumonan() {
        DataClient dataClient = APIUtils.getData();
        Call<List<Monan>> callback = dataClient.Dsmonan(tenmonan,hinhmonan);
        callback.enqueue(new Callback<List<Monan>>() {
            @Override
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> response) {
                ArrayList<Monan> monans = (ArrayList<Monan>) response.body();
                monanAdapter = new MonanAdapter(monans,getApplicationContext());
                lvmanhinhchinh.setAdapter(monanAdapter);
                monanAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {

            }
        });
    }

    private void actionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://pasgo.vn/Upload/anh-slide-show/bep-oc-sai-gon---du-mon-ngon-tu-oc-118484781578.jpg");
        mangquangcao.add("https://pasgo.vn/Upload/anh-slide-show/sushi-house---tinh-hoa-am-thuc-nhat-ban-114210241581.jpg");
        mangquangcao.add("https://pasgo.vn/Upload/anh-slide-show/pho-79---am-thuc-doc-dao-trong-khong-gian-sang-trong-167295001589.jpg");
        for(int i = 0; i<mangquangcao.size(); i++){
            ImageView imageView = new ImageView((getApplicationContext()));
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void actionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void anhxa(){
        toolbar = (Toolbar) findViewById(R.id.tbmhc);
        viewFlipper = (ViewFlipper) findViewById(R.id.vlp);
        lvtrangchinh = (ListView) findViewById(R.id.lvtrangchinh) ;
        lvmanhinhchinh = (ListView) findViewById(R.id.lvmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);

    }
}