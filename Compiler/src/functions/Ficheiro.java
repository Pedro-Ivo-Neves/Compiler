package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
            System.out.println(e.getMessage());
        }
        return palavras;
    }

    //? Neste metodo ele lê o ficheiro e capta cada Token
    public ArrayList<Token_Model> lerficheiro(){
        StringTokenizer strT;
        var tokens  = new ArrayList<Token_Model>();

        String token;

        String linha;
        int linhaIndex=1;
        int columnIndex;
        
        try {
            
            linha = br.readLine();

            while(linha!=null){
                strT = new StringTokenizer(linha, " ");
                
                while(strT.hasMoreTokens()){
                    token = strT.nextToken();
                    columnIndex = linha.indexOf(token);

                    tokens.add(new Token_Model(token, linhaIndex, columnIndex+1));
                }

                linha = br.readLine();
                linhaIndex++;
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return tokens;
    }
}