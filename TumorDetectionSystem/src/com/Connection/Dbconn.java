/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Connection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbconn {

    public static String fpath="C:\\Users\\sony\\Desktop\\";
    
    public Dbconn() throws SQLException {
  
    }

    public Connection conn() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/wordpress_db", "root", "");// for local database
        return (con);

    }

}
