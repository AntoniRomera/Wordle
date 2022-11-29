/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.Random;
import java.io.*;

import wordle.Palabra;
import wordle.LT;
import wordle.WordleHint;
/**
 *
 * @author aromera
 */
public class Diccionario {
    
    private int language;
    long seed;
    int word_length;
    private final LT READER = new LT();
    
    public Diccionario(int language, int word_length) {
        this.language = language;
        this.word_length = word_length;
    }
    
    public Diccionario(int language, int word_length, long seed) {
        this.language = language;
        this.word_length = word_length;
        this.seed = seed;
    }
    
    
    private int generateRandom() {
        Random generator = new Random(this.seed);
        int max = 10; // Buscar maximo longitud fichero
        int index = generator.nextInt(max);

        return index;
    }
    
    public Palabra askAvailableWord(WordleHint criteria, int mode) {
        
        System.out.print("Inserta la palabra a jugar: ");
        char[] w = READER.leerLinea().toCharArray();
        while (w.length != this.word_length) {
            if (mode == 1 && w[0] == '?') {
                return new Palabra(w);
            }
            System.out.print("Longitud incorrecta, vuelva a intentarlo: ");
            w = READER.leerLinea().toCharArray();
        }
        return new Palabra(w);
    }
    
    public void showPossibleWords(WordleHint criteria) {
        
    }
    
    
    public Palabra randomSolution() {
        
        char[] w = {'t', 'e', 's', 't'};
        Palabra word = new Palabra(w);
        return word;
    }
    
    public Palabra officialSolution() {
        char[] w = {'t', 'e', 's', 't'};
        Palabra word = new Palabra(w);
        return word;
    }
    
}
