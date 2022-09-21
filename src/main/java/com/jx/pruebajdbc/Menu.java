/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jx.pruebajdbc;

import java.util.Scanner;

/**
 *
 * @author emidz
 */
public class Menu {

    public Menu() {
    }
    
    Scanner sc = new Scanner (System.in);
    
    public int menuImprimir(int op){
        
        System.out.println("Elija una opcion:");
        System.out.println("1 - Insertar. 2 - Update. 3 - Mostrar. 4 - Borrar. 5 - Salir. ");
        op = sc.nextInt ();
        
    return op;   
    }
}
