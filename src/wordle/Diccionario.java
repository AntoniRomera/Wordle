/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import wordle.Palabra;
import wordle.LT;
import wordle.WordleHint;
import wordle.FileIn;
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
    
    private String getLanguage() {
        String selected = "en";

        FileIn file = new FileIn("files/languages.txt");
        String line;
        while((line=file.readLine()) != null) {
            if ((int)(line.charAt(0) - '0') == this.language) {
                selected = line.substring(2, 4);
            }
        }
        file.close();
        return selected;
    }
    
    private String solutionsPath() {
        String language = this.getLanguage();
        if (this.word_length > 5) {
            return "files/wordle_" + language + "_solutions_" + this.word_length + ".txt";
        }
        return "files/wordle_" + language + "_solutions.txt";
    }
    
    private String wordsPath() {
        String language = this.getLanguage();
        if (this.word_length > 5) {
            return "files/wordle_" + language + "_wordlist_" + this.word_length + ".txt";
        }
        return "files/wordle_" + language + "_wordlist.txt";
    }
    
    private int maxLengthFile(String path) {
        
        FileIn file = new FileIn(path);
        int i = 0;
        while(file.readLine() != null) {
            i++;
        }
        
        return i;
    }

    private int generateRandom() {
        Random generator = new Random(this.seed);
        int max = this.maxLengthFile(this.solutionsPath()); // Buscar maximo longitud fichero
        int index = generator.nextInt(max);

        return index;
    }
    
    public Palabra askAvailableWord(WordleHint criteria, int mode) {
        
        System.out.print("Inserta la palabra a jugar: ");
        char[] w = READER.leerLinea().toCharArray();
        while (w.length != this.word_length) {
            if (mode == 1 && w[0] == '?') {
                this.showPossibleWords(criteria);
                System.out.print("Lea la ayuda y vuelva a insertar una palabra: ");
            } else {
                System.out.print("Longitud incorrecta, vuelva a intentarlo: ");
            }
            w = READER.leerLinea().toCharArray();
        }
        /**
         * La palabra no existe
         */
        while(!(this.wordExist(w))) {
            System.out.print("La palabra no existe, vuelva a intentarlo: ");
            w = READER.leerLinea().toCharArray();
        }
        
        while (mode == 2 && !(criteria.match(w))) {
            System.out.print("Ha eleigido el modo dificil, no puede "
                    + "insertar una palabra que no cumpla"
                    + "las pistas anteriores, vuelva a intentarlo: ");
            w = READER.leerLinea().toCharArray();
        }
        return new Palabra(w);
    }
    
    private boolean wordExist(char[] w) {
        FileIn file = new FileIn(this.wordsPath());
        String line;
        Palabra word = new Palabra(w);
        Palabra dictWord;
        boolean exist = false;
        while((line=file.readLine()) != null) {
            dictWord = new Palabra(line.toCharArray());

            if (dictWord.equal(word)) {
                exist = true;
            }
        }
        file.close();
        
        return exist;
    }
    
    public void showPossibleWords(WordleHint criteria) {
        String availables = "";
        FileIn file = new FileIn(this.wordsPath());
        String readed;
        while((readed=file.readLine()) != null) {
            char[] w = readed.toCharArray();

            if (criteria.match(w)) {
                if (availables == "") {
                    availables += readed;
                } else {
                    availables += ", " + readed;
                }
            }
        }
        file.close();
        System.out.println("Palabras disponibles: " + availables);
    }
    
    
    public Palabra randomSolution() {
        
        int line = this.generateRandom();
        
        FileIn file = new FileIn(this.solutionsPath());
        
        char[] w = new char[this.word_length];
        for (int i = 0; i < w.length; i++) {
            w[i] = '0';
        }
        String readed = file.readLineAt(line, w);
        if (readed == w.toString()) {
            System.out.println("Hubo un error, la palabra es " + w.toString());
        }
        Palabra word = new Palabra(readed.toCharArray());
        return word;
    }
    
    public Palabra officialSolution() {
        char[] w = {'t', 'e', 's', 't', 'e'};
        Palabra word = new Palabra(w);
        return word;
    }
    
}
