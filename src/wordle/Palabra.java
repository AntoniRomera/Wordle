/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 *
 * @author aromera
 */
public class Palabra {
    
    // Definicion de atributos 
    private char[] word; // Palabra a gestionar
    public int length;
    
    /**
     * Constructor indicado la palabra
     * @param word Indicamos la palabra a gestionar al inciar la instacia
     */
    public Palabra(char[] word) {
        this.word = word;
        this.length = word.length;
    }
    
    /**
     * Construcor indicando la longitud de la palabra
     * @param length Longitud de la palabra
     */
    public Palabra(int length) {
        this.word = new char[length];
        this.length = length;
    }
    
    /**
     * Metodo para la comparacion de palabras
     * @param objective Palabra a comparar
     * @return Devuelve true o false dependiendo si la palabra es igual
     */
    public boolean equal(Palabra objective) {
        
        for (int i = 0; i < this.word.length; i++) {
            if (this.indexToUpperCase(i) != objective.indexToUpperCase(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodo para la busqueda del indice de una letra
     * @param c Caracter a buscar dentro de la palabra
     * @return Devuelve el indice de la letra a buscar o -1 en caso de no estar
     * en la palabra
     */
    public int indexOf(char c) {
        int i;
        for (i = 0; i < this.word.length; i++) {
            if (this.indexToUpperCase(i) == this.toUpperCase(c)) {
                return i;
            }
        }
        return -1;
    }
    
    static private char toUpperCase(char c) {
        if (c >= (int)'a') {
            return (char)(c - (int)('a' - 'A'));
        }
        return c;
    }
    /**
     * Metodo para comparar indice por indice
     * @param c Caracter a comparar
     * @param i Indice que comparar
     * @return 
     */
    public boolean sameIndex(char c, int i) {
        return this.indexToUpperCase(i) == this.toUpperCase(c);
    }

    /**
     * Metodo para obtener el caracter del indice pasado
     * @param i Indice de la palabra
     * @return 
     */
    public char getIndex(int i) {
        return this.word[i];
    }
    
    // TODO: Preguntar si se puede hacer
    @Override
    public String toString() {
        String upper_word = "";
        for (int i = 0; i < this.length; i++) {
            upper_word += this.word[i];
        }
        return upper_word;
    }
    
    /**
     * Metodo para que devuelva la palabra
     * @return Palabra gestionada
     */
    public char[] getWord() {
        return this.word;
    }
    
    /**
     * Metodo para cambiar la palabra tras la incializacion
     * @param word Nueva palabra
     */
    public void setWord(char[] word) {
        this.word = word;
        this.length = word.length;
    }
    
    /**
     * Metodo para transformar una letra a mayuscula
     * @param index
     * @return 
     */
    public char indexToUpperCase(int index) {        
        return this.toUpperCase(this.word[index]);
    }
    
    public int maxOccurs(char c) {
        int occurs = 0;
        for (int i = 0; i < this.word.length; i++) {
            if (this.indexToUpperCase(i) == this.toUpperCase(c)) {
                occurs++;
            }
        }
        return occurs;
    }
    
}
