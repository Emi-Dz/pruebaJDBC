/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jx.data;

import com.jx.entity.Persona;
import com.jx.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM usuario";
    private static final String SQL_INSERT_ONE = "INSERT INTO usuario (username, password) VALUES (?, ?)";
    private static final String SQL_UPDATE_ONE = "UPDATE usuario SET username = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE_ONE = "DELETE FROM usuario WHERE username = ?";
    
    public List<Usuario> readAll(){
    
        Connection conn = null;
        PreparedStatement st = null;
        Usuario usuario = null;
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList<>();
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_SELECT_ALL);
            rs = st.executeQuery();
            while(rs.next()){
                
                usuario = new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("username"),
                            rs.getString("password")
                       
                        );
            
                lista.add(usuario);                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
            try {
                Conexion.close(rs);
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        return lista;
    
    } 
    
    public int insertUsuario(Usuario usuario) {
    
        int reg = 0;
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_INSERT_ONE);
           
            
            st.setString(1,usuario.getUserName());
            st.setString(2, usuario.getPassword());
            
            
            reg = st.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return reg;
    
    }
    
    public void deleteUsuario(Usuario usuario) {
    
        
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_DELETE_ONE);
           
            
            st.setString(1,usuario.getUserName());
            st.setString(2, usuario.getPassword());
            
            
            st.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    
    }
    
    public void updateUsuario (Usuario usuario){
        
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar ();
        
        try {
            st = conn.prepareStatement(SQL_DELETE_ONE);
            st.setString(1, usuario.getUserName());
            st.setString(2, usuario.getPassword());
        
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
