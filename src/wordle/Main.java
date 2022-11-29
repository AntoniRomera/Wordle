/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordle;

import wordle.LT;
import wordle.Wordle;
/**
 *
 * @author aromera
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final LT reader = new LT();
        final Wordle wordle = new Wordle();
        
        System.out.println("Bievenidos a WORDLE");
        System.out.println("-------------------\n");
        System.out.println("1 - Empezar a jugar (Modo basico)");
        System.out.println("2 - Modificar configuración");
        System.out.println("3 - Consultar Estadisticas");
        System.out.println("4 - Salir\n");
        System.out.print("Elige una opción: ");
        
        int option = reader.leerEntero();

        switch (option) {
            case 1: wordle.start(); break;
            case 2: wordle.startWithCustomSettings(); break;
            case 3: wordle.consultStatics(); break;
            case 4: break;
        }
    }
}

/**
 * Fichero con idiomas disponibles
 * Fichero con longitud de palabras disponibles
 */