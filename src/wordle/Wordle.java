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
        this.game.saveStatics();
        
        this.rematch();
    }
    
    public void startWithCustomSettings() {
        Settings settings = new Settings();
        settings.askPlayer();
        
        this.settings = settings;
        this.game.setSettings(settings);
        this.start();
    }
    
    private void rematch() {
        // TODO: exit menus with rematch options & statics
    }
    
    public void consultStatics() {
        
    }
}
