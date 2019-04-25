/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class User_history {
    private User user;
    private ArrayList<History> list;

    public User_history() {
    }

    public User_history(User user, ArrayList<History> list) {
        this.user = user;
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<History> getList() {
        return list;
    }

    public void setList(ArrayList<History> list) {
        this.list = list;
    }
    
}
