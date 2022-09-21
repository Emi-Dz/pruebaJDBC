package com.jx.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private static final String BD_URL = "jdbc:mysql://localhost:3306/jdbcprueba";
    private static final String BD_USER = "admin";
    private static final String BD_PASS = "admin";
    
    public static Connection conectar(){
        
        try {
            return DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static void close(Connection c) throws SQLException{
        c.close();
    }
    public static void close (Statement st) throws SQLException{
        st.close();
    }
    
    public static void close (PreparedStatement st) throws SQLException{
        st.close();
    }
    
    public static void close (ResultSet rs) throws SQLException{
        rs.close();
    }
    
}
