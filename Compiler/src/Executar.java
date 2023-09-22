import analysis.LexicalAnalysis;
import constants.KeyWords;

/**
 * @author Adila Mussa
 * @author Pedro Neves
 */
public class Executar {
    
    public static void main(String[] args) {

        new KeyWords();
        new LexicalAnalysis(".\\docs\\programs\\main4.java")
            // .lexicalTable()
            // .identifierList()
            .sintaticAnalise();

        System.out.println("\n");
    }
}