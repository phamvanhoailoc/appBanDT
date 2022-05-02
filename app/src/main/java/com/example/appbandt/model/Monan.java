package com.example.appbandt.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Monan {

@SerializedName("Idmonan")
@Expose
private String idmonan;
@SerializedName("Tenmonan")
@Expose
private String tenmonan;
@SerializedName("Hinhmonan")
@Expose
private String hinhmonan;

public String getIdmonan() {
return idmonan;
}

public void setIdmonan(String idmonan) {
this.idmonan = idmonan;
}

public String getTenmonan() {
return tenmonan;
}

public void setTenmonan(String tenmonan) {
this.tenmonan = tenmonan;
}

public String getHinhmonan() {
return hinhmonan;
}

public void setHinhmonan(String hinhmonan) {
this.hinhmonan = hinhmonan;
}

}