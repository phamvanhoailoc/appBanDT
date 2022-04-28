package com.example.appbandt.retofit2;

import com.example.appbandt.Taikhoan;

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
}
