import analysis.LexicalAnalysis;
import constants.KeyWords;

import functions.*;

public class Executar {
    
    public static void main(String[] args) {
        new KeyWords();
        new LexicalAnalysis(new FilesFunc(".\\docs\\programs\\main4.java").readCode()).lexicalTable();
    }
}