/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author duong
 */
public class History implements Serializable{
    private String full_name;
    private String cmnd;
    private int thang;
    private int nam;
    private float sotiendong;

    public History(String full_name, String cmnd, int thang, int nam, float sotiendong) {
        this.full_name = full_name;
        this.cmnd = cmnd;
        this.thang = thang;
        this.nam = nam;
        this.sotiendong = sotiendong;
    }

//    public History() {
//    }
//


    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public float getSotiendong() {
        return sotiendong;
    }

    public void setSotiendong(float sotiendong) {
        this.sotiendong = sotiendong;
    }

    
}
