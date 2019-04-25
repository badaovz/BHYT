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
import model.Assurance;
import model.User;

/**
 *
 * @author duong
 */
public class UserDAO {
    private ArrayList <User> users = new ArrayList();
    Connection con;

    

    public UserDAO() {
        this.con = MyConnection.getConnection();
    }
    
    
}
