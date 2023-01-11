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
public class FileOut {
    private FileWriter fr;
    private BufferedWriter br;
    private File file;
    private boolean newLine = true;
    
    public FileOut(String path) {
        try {
            this.file = new File(path);
            if (this.file.length() == 0) {
                this.newLine = false;
            }
            this.fr = new FileWriter(this.file, true);
            this.br = new BufferedWriter(this.fr);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public void write(String line) {
        try {
            if (this.newLine) {
                this.br.newLine();
            }
            this.br.write(line);
            this.br.flush();
        } catch(Exception ex) {
            ex.printStackTrace();
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
}
