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
        UpdatePersona();
        printSelect();
        
        
    }

    static void deletePersona(){
        PersonaRepository p = new PersonaRepository();
        int rows_affected = p.deletePersona(3);
        System.out.println(rows_affected);
    }

    static void insertPersona(){
        PersonaRepository p = new PersonaRepository();
        int rows_affected = p.insertPersona("Jesus", 2);
        System.out.println(rows_affected);
    }

    static void UpdatePersona(){
        PersonaRepository p = new PersonaRepository();
        int rows_affected = p.updatePersona("Mariano", 2, 4);
        System.out.println(rows_affected);
    }

    static void printSelectActors(){
        PersonaRepository p = new PersonaRepository();
        List<Map<String, Object>> resSql = p.getActors();
        System.out.println(resSql);
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
