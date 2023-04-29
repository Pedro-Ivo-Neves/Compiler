import java.util.ArrayList;

import analysis.LexicalAnalysis;
import constants.KeyWords;
import functions.*;

public class Executar {
    public static void main(String[] args) {
        new KeyWords();
        new LexicalAnalysis(new Ficheiro(".\\docs\\programs\\main2.txt").lerficheiro()).lexicalTable();
    }
}