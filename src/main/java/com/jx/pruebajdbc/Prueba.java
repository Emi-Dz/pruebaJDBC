
package com.jx.pruebajdbc;

import com.jx.data.PersonaDAO;
import com.jx.data.UsuarioDAO;
import com.jx.entity.Persona;
import com.jx.entity.Usuario;
import java.util.List;
import java.util.Scanner;


public class Prueba {

    public static void main(String[] args) {
            
        PersonaDAO pd1 = new PersonaDAO();
        
        Scanner sc = new Scanner (System.in);
        


         Menu m = new Menu();
         int op = 0;
         do{
             op = m.menuImprimir(op);
             
             switch (op){
                 case 1: 
                     Persona persona = new Persona();
                     System.out.println("Ingrese nombre");
                     persona.setNombre(sc.nextLine());
                     System.out.println("Ingrese apellido");
                     persona.setApellido(sc.nextLine());
                     System.out.println("Ingrese email");
                     persona.setEmail(sc.nextLine());
                     System.out.println("Ingrese Telefono");
                     persona.setTelefono(sc.nextLine());
                     
                     pd1.insertPersona(persona);
                     break;
                     
                 case 2:
                     Persona persona2 = new Persona();
                     System.out.println("Seleccione ID de la persona a updatear");
                     persona2.setIdPersona(Integer.parseInt(sc.nextLine()));
                     System.out.println("Ingrese nombre");
                     persona2.setNombre(sc.nextLine());
                     System.out.println("Ingrese apellido");
                     persona2.setApellido(sc.nextLine());
                     System.out.println("Ingrese email");
                     persona2.setEmail(sc.nextLine());
                     System.out.println("Ingrese Telefono");
                     persona2.setTelefono(sc.nextLine());
                     
                     pd1.updatePersona(persona2);
                     break;
           
                 case 3:
                     List<Persona> lista = pd1.readAllPersonas();
                     for (Persona p: lista){
                         System.out.println(p);
                     }
                     break;
                     
                 case 4: 
                     
                     System.out.println("Seleccione ID de la persona a borrar");
                     pd1.deletePersonaById(Integer.parseInt(sc.nextLine()));
                     System.out.println("DELETED...");
                     break;
                     
                 default:  
                     System.out.println("Ingrese una opcion valida");
                     break;
             }
            
         } while (op != 5);
        

        
        
        
        }
        
        
        }
        
        

    

