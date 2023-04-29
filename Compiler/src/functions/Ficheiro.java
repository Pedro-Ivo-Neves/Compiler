package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import constants.KeyWords;
import models.Token_Model;

public class Ficheiro {

    private BufferedReader br;
    
    public Ficheiro(String path){
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            System.out.println("Erro no ficheiro ler ficheiro! Com o seguinte erro"+e.getMessage());
        }
    }

    //? Neste metodo ele lê o ficheiro e capta cada palavra
    public ArrayList<String> readFile(String separador){
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
            System.out.println(e.getMessage());
        }
        return palavras;
    }

    //? Neste metodo ele lê caracter por caracter
    public ArrayList<Token_Model> readCode(){
        var sb = new StringBuilder();
        var tokens  = new ArrayList<Token_Model>();

        int linhaIndex = 1;
        int colunaIndex;

        String linha;

        try {
            linha = br.readLine();

            while(linha!=null){

                for (char letra : linha.toCharArray()) {

                    if(KeyWords.simbolosEspeciais.contains(letra)){

                        

                    }
                    
                }


                linhaIndex++;
                linha = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tokens;
    }
}