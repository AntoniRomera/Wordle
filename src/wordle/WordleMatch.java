/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle;

import wordle.Settings;
import wordle.Diccionario;
import wordle.Palabra;
import wordle.LT;
import wordle.WordleHint;
import com.diogonunes.CC;
/**
 *
 * @author aromera
 */
public class WordleMatch {
    
    private Settings settings;
    private Palabra solution;
    private final LT READER = new LT();
    private Diccionario word_manager;
    private WordleHint hints;
    private final char COMMAND_HELP = '?';
    private Palabra[] matchWords;
    private int roundsPlayed;
    
    public WordleMatch(Settings settings) {
        this.settings = settings;
        this.word_manager = new Diccionario(settings.getLanguage(), settings.getLength(), settings.getSeed());
        this.hints =  new WordleHint(settings.getLength());
    }
    
    public void setSettings(Settings settings) {
        this.settings = settings;
        this.word_manager = new Diccionario(settings.getLanguage(), settings.getLength(), settings.getSeed());
        this.hints = new WordleHint(settings.getLength());
    }

    public void start() {
        // Buscar palabra
        // Indice random
        
        int mode = this.settings.getMode();
        int rounds = this.settings.getRounds();
        if (mode == 4) {
            // this.settings.getDate()
            this.solution = word_manager.officialSolution(); //pasar fecha
        } else {
            this.solution = word_manager.randomSolution();
        }
        this.soutTemplate();
        
        int round;
        this.matchWords = new Palabra[rounds];

        Palabra word = word_manager.askAvailableWord(this.hints, mode);
        for (round = 1; round <= rounds; round++) {
            this.matchWords[round - 1] = word;
            while (round == 1 && word.getIndex(0) == this.COMMAND_HELP && mode == 1) {
                System.out.println("No se puede pedir ayuda en la primera ronda");
                word = word_manager.askAvailableWord(this.hints, mode);
            }
            
            if ((word.getIndex(0) == '?' && mode == 1) || (mode == 5 && round > 1)) {
                word_manager.showPossibleWords(this.hints);
                word = word_manager.askAvailableWord(this.hints, mode);
            }
            if (this.solution.equal(word)) {
                // Mostrar palabra toda en verde
                break;
            }
            
            /**
             * Rellenar pistas
             */
            this.compareSolution(word);
            
            /**
             * Preguntar nueva palabra
             */
            word = word_manager.askAvailableWord(this.hints, mode);
        }
        
        this.roundsPlayed = round;
        
    }
    
    public void saveStatics() {
        
    }
    
    private void soutTemplate() {
        for (int i = 0; i < this.solution.length; i++) {
            CC.impr(" ", CC.TBlanc, CC.FBlanc);
            if (i < this.solution.length - 1) {
                System.out.print("|");
            }
        }   
    }
    
    private void compareSolution(Palabra word) {
        char c;
        char cU;
        for (int i = 0; i < word.length; i++) {
            c = word.getIndex(i);
            cU = word.getIndex(i);
            if (c >= (int)'a') {
                cU = (char)(c - (int)('a' - 'A'));
            }
            int index = this.solution.indexOf(c);
            if (index == -1) {
                this.hints.setOutWord(c);
                CC.impr(""+cU, CC.TBlanc, CC.FBlanc);
            } else {
                boolean sameIndex = this.solution.sameIndex(c, i);
                if (sameIndex) {
                    this.hints.setCorrectIndex(i, c);
                    CC.impr(""+cU, CC.TBlanc, CC.FVerd);
                }
                else {
                    this.hints.setInWord(c);
                    CC.impr(""+cU, CC.TBlanc, CC.FGroc);
                }
            }
            
            if (i < word.length - 1) {
                System.out.print("|");
            }
        }
    }
    
}
