/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import java.io.*;

/**
 *
 * @author aromera
 */
public class FileIn {
    
    FileReader fr;
    BufferedReader br;
    
    public FileIn(String path) {
        try {
            this.fr = new FileReader(path);
            this.br = new BufferedReader(this.fr);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String readLine() {
        try {
            return this.br.readLine();
        } catch(Exception ex) {
            return null;
        }
    }
    
    public void close() {
        try {
            this.br.close();
            this.fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String readLineAt(int line, char[] default_word) {
        try {
            String readed = this.br.readLine();
            for(int i= 0; i <= line; i++) {

                if (i == line) {
                    System.out.println(readed);
                    return readed;
                }
                readed = this.br.readLine();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return default_word.toString();
    }
    
}
