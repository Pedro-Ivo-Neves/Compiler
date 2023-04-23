import analysis.LexicalAnalysis;
import functions.*;

public class Executar {
    public static void main(String[] args) {
        System.out.println("\033[2J");
        new LexicalAnalysis(new Ficheiro(".\\docs\\programs\\main2.txt").lerficheiro(" ")).lexicalTable();
    }
}