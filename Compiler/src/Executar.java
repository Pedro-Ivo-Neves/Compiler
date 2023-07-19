import analysis.LexicalAnalysis;
import constants.KeyWords;

// import functions.*;

public class Executar {
    
    public static void main(String[] args) {

        /*
         ! Tabela Identificadores
         */

        new KeyWords();
        new LexicalAnalysis(".\\docs\\programs\\main4.java")
            // .lexicalTable()
            .identifierList();
            // .sintaticAnalise();

        System.out.println("\n");
    }
}