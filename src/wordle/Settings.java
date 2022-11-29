/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import wordle.LT;
import wordle.Diccionario;
/**
 *
 * @author aromera
 */
public class Settings {
    
    private int length = 5; // Longitud con la que jugamos
    private int rounds = 6; // Rondas a jugar
    /**
     * Modos:
     *  0: basico
     *  1: facil
     *  2: dificil
     *  3: vs
     *  4: oficial
     *  5: trampa
     *  6: reforzado
     */
    private int mode = 0;
    private int language = 2;
    private long seed = System.currentTimeMillis();
    private final LT READER = new LT();
    
    // TODO: Modo oficial, indicar fecha
    // private date;
    
    
    public void askPlayer() {
        // ask for mode 
        System.out.println("Menu Configuracion");
        System.out.println("------------------");
        System.out.println("1 - Seleccionar modo de juego (default: Modo basico)");
        if (this.mode != 4) {
            System.out.println("2 - Longitud de la palabra (default: 5)");
        } else {
            System.out.println("2 - Longitud de la palabra (Opcion no permitida en modo oficial)");
        }
        System.out.println("3 - Numero de rondas (default: 6)");
        System.out.println("4 - Idioma (default: en)");
        System.out.println("5 - Empezar a jugar");
        System.out.print("Elige una opción: ");
        
        int option = this.READER.leerEntero();
        
        while(option < 1) {
            System.out.println("Opcion incorrecta");
            option = this.READER.leerEntero();
        }
        
        switch(option) {
            case 1: this.askMode(); break;
            case 2: if (this.mode != 4) {
                this.askLength();
            } else {
                System.out.println("Opcion no permitda en el modo oficial");
                this.askPlayer();
            }
            break;
            case 3: this.askRounds(); break;
            case 4: this.askLanguage(); break;
            case 5: break;
        }
        
    }
    
    private void askLanguage() {
        try {
            System.out.println("Idioma");
            System.out.println("------");
            File file = new File("/Users/aromera/Documents/UIB/Programacio/Wordle/src/wordle/languages.txt");
            FileReader fileReader = new FileReader(file); 
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            char[] lineArray;
            while((line=reader.readLine()) != null) {
                lineArray = line.toCharArray();
                System.out.println(lineArray[0] + " - " + lineArray[2] + lineArray[3]);
            }
            System.out.print("\nElige una opción: ");
            int language = this.READER.leerEntero();
            
            this.language = language;
            
            this.askPlayer();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void askLength() {
        System.out.println("Longitud de la palabra");
        System.out.println("----------------------\n");
        System.out.print("Indica la longitud de la palabra: ");
        
        int length = this.READER.leerEntero();
        
        this.length = length;
        
        this.askPlayer();
    }
    
    private void askRounds() {
        System.out.println("Numero de rondas");
        System.out.println("----------------\n");
        System.out.print("Indica el numero de rondas: ");
        
        int rounds = this.READER.leerEntero();
        
        this.rounds = rounds;
        
        this.askPlayer();
    }
    
    private void askMode() {
        System.out.println("Seleccion modo de juego");
        System.out.println("-----------------------");
        System.out.println("0 - Modo basico");
        System.out.println("1 - Modo facil");
        System.out.println("2 - Modo dificil");
        System.out.println("3 - Modo VS");
        System.out.println("4 - Modo Oficial");
        System.out.println("5 - Modo Trampa");
        System.out.println("6 - Modo reforzado\n");
        System.out.print("Elige una opción: ");
        int mode = this.READER.leerEntero();
        
        while(mode < 0 || mode > 6) {
            System.out.print("Modo no accesible, indique uno de la lista: ");
            mode = this.READER.leerEntero();
        }
        this.mode = mode;
        
        
        if (mode == 3) {
            this.vsMode();
        }
        
        this.askPlayer();
    }
    
    
    private void vsMode() {
        System.out.println("Modo VS");
        System.out.println("-------");
        System.out.println("1 - Insertar seed");
        System.out.println("2 - Mostrar seed y salir\n");
        System.out.println("3 - Salir\n");
        System.out.print("Elige una opción: ");
        
        int option = this.READER.leerEntero();
        
        
        switch (option) {
            case 1: 
                System.out.print("Seed: ");
                double seed = this.READER.leerEntero();
                this.seed = (long)seed;
                break;
            case 2:
                System.out.println("Seed: " + this.seed);
                break;
            case 3:
                break;
        }
    }
    
    public int getMode() {
        return this.mode;
    }
    public int getLanguage() {
        return this.language;
    }
    public int getLength() {
        return this.length;
    }
    public int getRounds() {
        return this.rounds;
    }
    
    public long getSeed() {
        return this.seed;
    }
    
}
