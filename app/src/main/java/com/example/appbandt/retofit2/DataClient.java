package com.example.appbandt.retofit2;

import com.example.appbandt.Taikhoan;
import com.example.appbandt.model.Monan;
import com.example.appbandt.model.Nhahang;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DataClient {
    @FormUrlEncoded
    @POST("login.php")
    Call<List<Taikhoan>> Logindata(@Field("sdt") String sdt,
                                   @Field("matkhau") String matkhau);
    @FormUrlEncoded
    @POST("insert.php")
    Call<String> InsertData(@Field("sdt") String sdt
                            ,@Field("matkhau") String matkhau);
    @FormUrlEncoded
    @POST("monan.php")
    Call<List<Monan>> Dsmonan(
            @Field("tenmonan") String tenmonan
            ,@Field("hinhmonan") String hinhmonan);
    @FormUrlEncoded
    @POST("nhahang.php")
    Call<List<Nhahang>> Dsnhahang(
            @Field("tennhahang") String tennhahang
            ,@Field("diachi") String diachi
            ,@Field("gia") Float gia
            ,@Field("giomocua") Time giomocua
            ,@Field("giodongcua") Time giodongcua
            ,@Field("hinhnhahang") String hinhnhahang);
}
