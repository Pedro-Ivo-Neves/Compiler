import java.util.ArrayList;

import analysis.LexicalAnalysis;
import constants.KeyWords;
import functions.*;

public class Executar {
    public static void main(String[] args) {
        // new KeyWords();
        // new LexicalAnalysis(new Ficheiro(".\\docs\\programs\\main3.txt").readCode()).lexicalTable();
        // int i =0;
        // while (i<10) {
        //     if (i<3) {
        //         System.out.println("I: "+i);
        //         i++;
        //     } else {
        //         break;
        //     }
        // }

        var sb = new StringBuilder();

        var list = new ArrayList<String>();

        int columnIndex=1;

        String p = "Lol Lki";

        
        System.out.println("Length: "+p.length());
        for (char letra : p.toCharArray()) {
            columnIndex++;
            if (letra==' ' || columnIndex==p.length()+1) {
                if(columnIndex==p.length()+1){
                    sb.append(letra);
                }
                String palavra = (sb.length()!=0) ? sb.toString():null;

                if(palavra.equals(null)){
                    continue;
                } else{
                    list.add(palavra);
                    sb.delete(0, sb.length());
                }

            } else{
                sb.append(letra);
            }
        }

        list.forEach((l)->System.out.println("As Palavras sao: "+l));
    }
}