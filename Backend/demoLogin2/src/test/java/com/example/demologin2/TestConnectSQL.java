package com.example.demologin2;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectSQL {
    public static void main(String [] args) throws Exception {
        // Class.forName( "com.mysql.jdbc.Driver" ); // do this in init
        // // edit the jdbc url
        Connection conn = DriverManager.getConnection(
                "com.mysql.cj.jdbc.Driver?user=root1&password=root");
        // Statement st = conn.createStatement();
        // ResultSet rs = st.executeQuery( "select * from table" );

        System.out.println("Connected?");
    }
}
