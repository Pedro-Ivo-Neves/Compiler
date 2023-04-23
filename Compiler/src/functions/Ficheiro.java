package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ficheiro {

    private BufferedReader br;
    
    public Ficheiro(String path){
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            System.out.println("Erro no ficheiro ler ficheiro! Com o seguinte erro"+e.getMessage());
        }
    }

    //? Neste metodo ele lê o ficheiro e capta cada palavra desde que tenha um espaço vazio
    public ArrayList<String> lerficheiro(String separador){
        StringTokenizer strT;
        var palavras  = new ArrayList<String>();

        String linha;
        try {
            linha = br.readLine();

            while(linha!=null){
                strT = new StringTokenizer(linha, separador);
                
                while(strT.hasMoreTokens()){
                    palavras.add(strT.nextToken());
                }

                linha = br.readLine();
            }

            br.close();

        } catch (IOException e) {
            e.getMessage();
        }
        for (String word : palavras) {
            System.out.println(word);
        }

        return palavras;
    }
}