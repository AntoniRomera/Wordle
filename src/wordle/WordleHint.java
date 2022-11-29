/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

/**
 *
 * @author aromera
 */
public class WordleHint {
    
    private char[] inWord;
    private char[] outWord;
    private char[] correctIndex;
    
    public WordleHint(int length) {
        this.inWord = new char[length];
        this.outWord = new char[length];
        this.correctIndex = new char[length];
        
        this.fillGaps();
    }
    
    private void fillGaps() {
        
        for(int i = 0; i < this.inWord.length; i++) {
            this.inWord[i] = '*';
            this.outWord[i] = '*';
            this.correctIndex[i] = '*';
        }
    }
    
    
    public void setCorrectIndex(int i, char c) {
        this.correctIndex[i] = c;
    }
    
    public void setInWord(char c) {
        for (int i = 0; i < this.inWord.length; i++) {
            if (this.inWord[i] == '*') {
                this.inWord[i] = c;
                break;
            }
        }
    }
    
    public void setOutWord(char c) {
        for (int i = 0; i < this.outWord.length; i++) {
            if (this.outWord[i] == '*') {
                this.outWord[i] = c;
                break;
            }
        }
    }
    
    public boolean anyHint() {
        
        if (this.anyInWord()) {
            return true;
        }
        
        if (this.anyCorrectIndex()) {
            return true;
        }
        
        if (this.anyOutWord()) {
            return true;
        }
        
        return false;
    }
    
    private boolean anyInWord() {
        
        for (int i = 0; i < this.inWord.length; i++) {
            if (this.inWord[i] != '*') {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean anyOutWord() {
        for (int i = 0; i < this.outWord.length; i++) {
            if (this.outWord[i] != '*') {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean anyCorrectIndex() {
        for (int i = 0; i < this.correctIndex.length; i++) {
            if (this.correctIndex[i] != '*') {
                return true;
            }
        }
        
        return false;
    }
}
