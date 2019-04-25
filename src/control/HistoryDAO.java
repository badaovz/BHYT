/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.History;

/**
 *
 * @author duong
 */
public class HistoryDAO {

    //   private ArrayList<History> historylist = new ArrayList();
    public HistoryDAO() {
    }

    Connection conn;

    public HistoryDAO(Connection conn) {
        this.conn = MyConnection.getConnection();

    }

//    public ArrayList<History> searchHistory(String key){
//        ArrayList<History> result = new ArrayList();
//        String sql = "SELECT `full_name`, `cmnd`, `thang`, `nam`, `sotiendong` FROM `history` WHERE full_name LIKE  ? ";
//        try{
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, "%"+key+"%");
//            ResultSet rs =ps.executeQuery(sql);
//            
//            while(rs.next()){
//                History history = new History();
//                history.setCmnd(rs.getString("cmnd"));
//                history.setFull_name(rs.getString("full_name"));
//                history.setThang(rs.getInt("thang"));
//                history.setNam(rs.getInt("nam"));
//                history.setSotiendong(rs.getFloat("sotiendong"));
//                result.add(history);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
    public ArrayList<History> searchHistory(String ValToSearch) {

        ArrayList<History> result = new ArrayList<History>();
        
        
        //-------ed-----
        History history = null;
        //-------
        try {

            Statement st;
            ResultSet rs;

            String searchQuery = "SELECT `full_name`, `cmnd`, `thang`, `nam`, `sotiendong` FROM `history` WHERE full_name LIKE  '%" + ValToSearch + "%'";

            //-------------edit-------------
            
            conn = MyConnection.getConnection();
            //------------------------
            
            st = conn.createStatement();

            rs = st.executeQuery(searchQuery);

            while (rs.next()) {

                String name = rs.getString("full_name");
                String cmnd = rs.getString("cmnd");
                int thang   = rs.getInt("thang");
                int nam     = rs.getInt("nam");
                float sotien = rs.getFloat("sotiendong");
                
                //------------edit--------------------------//
                
                history = new History(name, cmnd, thang, nam, sotien);
                
                //------------------------
                
                result.add(history);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //System.out.println(history.getFull_name());
//        System.out.println(result);
        return result;
    }
}
