/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Setting;

/**
 *
 * @author duong
 */
public class SettingDAO {
    private ArrayList<Setting> setting = new ArrayList();
    Connection con;

   

    public SettingDAO() {
        this.con = MyConnection.getConnection();
    }
    public Setting getSetting(){
       
        try{
            String query ="SELECT * FROM `setting` ORDER BY id DESC LIMIT 1";
            ResultSet rs= con.createStatement().executeQuery(query);
            while(rs.next()){
                return new Setting(rs.getFloat("bh1"),
                rs.getFloat("hotro1"),
                rs.getFloat("hotro2"),
                rs.getFloat("hotro3"));
            }
//            return setting;
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return null;
    }
    public void addSetting(Setting setting){
        try{
            String query="INSERT INTO `setting`(`bh1`, `hotro1`, `hotro2`, `hotro3`) VALUES (?,?,?,?)";
            PreparedStatement ps=this.con.prepareStatement(query);
            ps.setFloat(1, setting.getBh1());
            ps.setFloat(2, setting.getHotro1());
            ps.setFloat(3, setting.getHotro2());
            ps.setFloat(4, setting.getHotro3());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
            
    }
}
