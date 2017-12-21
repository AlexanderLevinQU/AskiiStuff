package com.example.alex.askii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alex on 12/21/2017.
 */

public class Select {
    private Connection connect() {
        //Create sqlite connection
        String url = "jdbc:sqlite:C://";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alex\\eclipse-workspace\\AskiiDBs\\src\\login.sqlite");
        } catch (Exception e) {
        }
        return conn;

    }

    public String getUserName(String userName) {
        //Cneed to deal with sql injections
        String sql = "SELECT username FROM loginInfo WHERE username = " + userName;
        Connection conn = this.connect();
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
        }catch(SQLException e){
            //error
        }
        ResultSet rs = null;
        try{
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            //error
        }
        String actualUser = null;
        try{
            actualUser = rs.getString("username");
        }catch(SQLException e){
            //error
        }
        return actualUser;
    }

    public String getPassword(String passWord){
        //Need to deal with sql injections
        String sql = "SELECT username FROM loginInfo WHERE password = " + passWord;
        Connection conn = this.connect();
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
        }catch(SQLException e){
            //error
        }
        ResultSet rs = null;
        try{
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            //error
        }
        String actualPass = null;
        try{
            actualPass = rs.getString("password");
        }catch(SQLException e){
            //error
        }
        return actualPass;

    }
}