package org.example;

import org.example.model.ClaseEntityEjemplo;
import org.example.model.PersonaCliente;
import org.example.model.PersonaMultiPerfil;
import org.example.repository.PersonaRepository;

import java.util.List;
import java.util.Map;

public class Mvnprojectexample {

    public static void main(String[] args) {

		//Testing
        printSelect();
        printSelectMultiperfil();
        printSelectCliente();
        ClaseEntityEjemplo ex = new ClaseEntityEjemplo(1, "nombre","value");
        
        
    }
    
    static void printSelect(){
        PersonaRepository p = new PersonaRepository();
        List<Map<String, Object>> resSql = p.getPersonas();
        System.out.println(resSql);
    }
    
    static void printSelectMultiperfil(){
        PersonaRepository p = new PersonaRepository();
        PersonaMultiPerfil resSql = p.getPersonaMultiPerfil(1);
        System.out.println(resSql);
    }
    
    static void printSelectCliente(){
        PersonaRepository p = new PersonaRepository();
        PersonaCliente resSql = p.getPersonaCliente(2);
        System.out.println(resSql);
    }
    
    static void printSelectId(){
        PersonaRepository p = new PersonaRepository();
        Map<String, Object> resSql = p.getPersona(1);
        System.out.println(resSql);
    }
    
    static void hardcode(){
        PersonaMultiPerfil scarlet = new PersonaMultiPerfil(1, "Scarlett Johanson");
        scarlet.accion();
        
        PersonaCliente juan = new PersonaCliente(2, "Juan Perez");
        juan.accion();
    }
}
