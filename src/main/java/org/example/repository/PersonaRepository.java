package org.example.repository;

import org.example.model.PersonaCliente;
import org.example.model.PersonaMultiPerfil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaRepository {
    
    ConnectionDB conDB = new ConnectionDB();
    Connection con = null;
    
    public PersonaRepository(){
        try {
            con = conDB.createConnection();
        } catch (SQLException ex) {
            System.out.println("ERROR");
        }
    }
    
    void closeConnection(){
        try {
            conDB.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println("ERROR CLOSING");
        }
    }
    
    public Map<String, Object> getPersona(int id){
        Map<String, Object> result = new HashMap<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM blockbuster.persona WHERE id = ".concat("" + id));
            while(rs.next()){
                result.put("id", rs.getInt(1));
                result.put("nombre", rs.getString(2));
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int deletePersona(int id){
        int rows_affected = 0;
        try {
            Statement st = con.createStatement();
            rows_affected = st.executeUpdate("DELETE FROM blockbuster.persona WHERE id = ".concat("" + id));
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows_affected;
    }

    public int insertPersona(String nombre, int tipo){
        int rows_affected = 0;
        try {
            String sql = "INSERT INTO blockbuster.persona (nombre, tipo) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setInt(2, tipo);
            rows_affected = pst.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows_affected;
    }

    public int updatePersona(String nombre, int tipo, int id_persona){
        int rows_affected = 0;
        try {
            String sql = "UPDATE blockbuster.persona SET nombre = ?, tipo = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setInt(2, tipo);
            pst.setInt(3, id_persona);
            rows_affected = pst.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows_affected;
    }
    
    public List<Map<String, Object>> getPersonas(){
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Statement st = conDB.createConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM blockbuster.persona");
            while(rs.next()){
                Map<String, Object> resultRow = new HashMap<>();
                resultRow.put("id", rs.getInt(1));
                resultRow.put("nombre", rs.getString(2));
                result.add(resultRow);
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Map<String, Object>> getActors(){
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Statement st = conDB.createConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM blockbuster.persona where tipo = 1");
            while(rs.next()){
                Map<String, Object> resultRow = new HashMap<>();
                resultRow.put("id", rs.getInt(1));
                resultRow.put("nombre", rs.getString(2));
                result.add(resultRow);
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public PersonaMultiPerfil getPersonaMultiPerfil(int tipo){
        PersonaMultiPerfil p = new PersonaMultiPerfil();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM blockbuster.persona WHERE tipo = ".concat("" + tipo));
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public PersonaCliente getPersonaCliente(int tipo){
        PersonaCliente p = new PersonaCliente();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM blockbuster.persona WHERE tipo = ".concat("" + tipo));
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
