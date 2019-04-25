/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author duong
 */
public class Setting {
    private float bh1;
    private float hotro1;
    private float hotro2;
    private float hotro3;

    public Setting() {
    }

    public Setting(float bh1, float hotro1, float hotro2, float hotro3) {
        this.bh1 = bh1;
        this.hotro1 = hotro1;
        this.hotro2 = hotro2;
        this.hotro3 = hotro3;
    }

    public float getBh1() {
        return bh1;
    }

    public void setBh1(float bh1) {
        this.bh1 = bh1;
    }

    public float getHotro1() {
        return hotro1;
    }

    public void setHotro1(float hotro1) {
        this.hotro1 = hotro1;
    }

    public float getHotro2() {
        return hotro2;
    }

    public void setHotro2(float hotro2) {
        this.hotro2 = hotro2;
    }

    public float getHotro3() {
        return hotro3;
    }

    public void setHotro3(float hotro3) {
        this.hotro3 = hotro3;
    }
    
}
