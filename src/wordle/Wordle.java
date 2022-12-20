/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import wordle.Settings;
import wordle.WordleMatch;
/**
 *
 * @author aromera
 */
public class Wordle {
    
    private Settings settings;
    private WordleMatch game;
    private String player;
    
    /**
     * Constructor con los ajustes basicos
     */
    public Wordle() {
        this.settings = new Settings();
        this.game = new WordleMatch(this.settings);
    }
    
    /**
     * Constructor con ajustes personalizados
     * @param settings 
     */
    public Wordle(Settings settings) {
        this.settings = settings;
        this.game = new WordleMatch(settings);
    }
    
    public void start() {
        this.game.start();
        this.game.saveStatics(this.player);
        
        this.rematch();
    }
    
    public void startWithCustomSettings() {
        Settings settings = new Settings();
        settings.askPlayer();
        
        this.settings = settings;
        this.game.setSettings(settings);
        this.start();
    }
    
    public void rematch() {
        final LT reader = new LT();
        
        System.out.println("Quieres seguir jugando?");
        // TODO
    }
    
    public void setPlayer(String player) {
        this.player = player;
    }
    
    public void consultStatics() {
        
    }
}
