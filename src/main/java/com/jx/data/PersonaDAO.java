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

public class PersonaDAO {
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM persona";
    private static final String SQL_INSERT_ONE = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_ONE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE_ONE = "DELETE FROM persona WHERE id_persona = ?";
    
    public List<Persona> readAllPersonas(){
    
        Connection conn = null;
        PreparedStatement st = null;
        Persona persona = null;
        ResultSet rs = null;
        List<Persona> lista = new ArrayList<>();
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_SELECT_ALL);
            rs = st.executeQuery();
            while(rs.next()){
                
                persona = new Persona(
                            rs.getInt("id_persona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("email"),
                            rs.getString("telefono")
                        );
            
                lista.add(persona);                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
            try {
                Conexion.close(rs);
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        return lista;
    
    } 
    
    public int insertPersona(Persona persona) {
    
        int reg = 0;
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_INSERT_ONE);
           
            
            st.setString(1,persona.getNombre());
            st.setString(2, persona.getApellido());
            st.setString(3, persona.getEmail());
            st.setString(4, persona.getTelefono());
        
            reg = st.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return reg;
    
    }
    
    public void updatePersona(Persona persona){
        
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_UPDATE_ONE);
           
            st.setInt(5, persona.getIdPersona());
            
            st.setString(1,persona.getNombre());
            st.setString(2, persona.getApellido());
            st.setString(3, persona.getEmail());
            st.setString(4, persona.getTelefono());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    
    
    }
    
    public void deletePersonaById(int i){
        
        Connection conn = null;
        PreparedStatement st = null;
        
        conn = Conexion.conectar();
        try {
            st = conn.prepareStatement(SQL_DELETE_ONE);
            
            st.setInt(1, i);
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
        
            try {
                Conexion.close(st);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    
    
    }

    
    
}
