package com.example.appbandt.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Nhahang {

@SerializedName("Idnhahang")
@Expose
private String idnhahang;
@SerializedName("Tennhahang")
@Expose
private String tennhahang;
@SerializedName("Diachinhahang")
@Expose
private String diachinhahang;
@SerializedName("Gia")
@Expose
private String gia;
@SerializedName("Giomocua")
@Expose
private String giomocua;
@SerializedName("Giodongcua")
@Expose
private String giodongcua;
@SerializedName("Hinhanhnhahang")
@Expose
private String hinhanhnhahang;
@SerializedName("Idmonan")
@Expose
private String idmonan;

public String getIdnhahang() {
return idnhahang;
}

public void setIdnhahang(String idnhahang) {
this.idnhahang = idnhahang;
}

public String getTennhahang() {
return tennhahang;
}

public void setTennhahang(String tennhahang) {
this.tennhahang = tennhahang;
}

public String getDiachinhahang() {
return diachinhahang;
}

public void setDiachinhahang(String diachinhahang) {
this.diachinhahang = diachinhahang;
}

public String getGia() {
return gia;
}

public void setGia(String gia) {
this.gia = gia;
}

public String getGiomocua() {
return giomocua;
}

public void setGiomocua(String giomocua) {
this.giomocua = giomocua;
}

public String getGiodongcua() {
return giodongcua;
}

public void setGiodongcua(String giodongcua) {
this.giodongcua = giodongcua;
}

public String getHinhanhnhahang() {
return hinhanhnhahang;
}

public void setHinhanhnhahang(String hinhanhnhahang) {
this.hinhanhnhahang = hinhanhnhahang;
}

public String getIdmonan() {
return idmonan;
}

public void setIdmonan(String idmonan) {
this.idmonan = idmonan;
}

}