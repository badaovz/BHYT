/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author duong
 */
public class Assurance {
    private String thang;
    private Date ngay;
    private float tienBH;
    private float thunhapCB;
    

    public Assurance() {
    }

    public Assurance(String thang, Date ngay, float tienBH, float thunhapCB) {
        this.thang = thang;
        this.ngay = ngay;
        this.tienBH = tienBH;
        this.thunhapCB = thunhapCB;
    }

   
    public Assurance( float tienBH, Date ngay) {
        this.tienBH= tienBH;
        this.ngay = ngay;
  
       
    }


    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public float getTienBH() {
        return tienBH;
    }

    public void setTienBH(float tienBH) {
        this.tienBH = tienBH;
    }

    public float getThunhapCB() {
        return thunhapCB;
    }

    public void setThunhapCB(float thunhapCB) {
        this.thunhapCB = thunhapCB;
    }
    
}
