/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author duong
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection con = null;
         try{
             //Class.forName("com.mysql.jdbc.Driver");
             //con = DriverManager.getConnection("jdbc:mysql://localhost/sqa1", "root","" );
             String url  = "jdbc:mysql://localhost:3308/MyDBBHYT";
             Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, "root", "1");
            System.out.println("Connect success");
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
         return con;
    }
   
}
