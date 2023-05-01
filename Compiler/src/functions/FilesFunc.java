package functions;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.StringTokenizer;

import constants.KeyWords;
import models.Token_Model;

public class FilesFunc {

    public static String programPath = ".\\docs\\programs\\";

    private BufferedReader br;
    
    public FilesFunc(String path){
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
    public LinkedList<Token_Model> readCode(){
        var sb = new StringBuilder();
        var tokens  = new LinkedList<Token_Model>();

        int linhaIndex = 1;
        int colunaIndex;

        int colunaUltimoChar=-1;

        String linha;

        try{
            linha = br.readLine();

            while(linha!=null){

                colunaIndex=0;

                for (char letra : linha.toCharArray()) {
                    colunaIndex++;
            
                    if(!sb.isEmpty()){ 

                        if(sb.charAt(0)=='/'){

                            if(sb.charAt(1)=='*'){
                                
                                if(colunaUltimoChar == linha.length()-1 && colunaUltimoChar>=1){
                                    if(sb.charAt(sb.length()-1)=='*' && letra=='/'){
                                        sb.setLength(0);
                                    }
                                    break;
                                }

                                if(letra=='*'){
                                    sb.append(letra);
                                    colunaUltimoChar=colunaIndex;
                                }

                                if(letra=='/'){
                                    if(colunaUltimoChar==colunaIndex-1){
                                        sb.setLength(0);
                                    }

                                    continue;
                                }
                                
                            }

                            if(letra=='/'){
                                sb.setLength(0);
                                break;
                            }

                            if(letra=='*'){
                                sb.append(letra);
                                continue;
                            }

                            if(KeyWords.constantesNumericas.contains(letra+"")){
                                System.out.println("Palavra: "+sb.toString());
                                tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex-1));
                                sb.setLength(0);
                                tokens.add(new Token_Model(letra+"", linhaIndex, colunaIndex));
                                continue;
                            }
                        }

                        if(sb.charAt(0)=='\"'){
                            
                            sb.append(letra);
                            
                            if(letra=='\"' && sb.length()>1){
                                tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex));
                                sb.setLength(0);
                            }
                            continue;
                        }
                    } 

                    
        
                    if(KeyWords.simbolosEspeciais.contains(""+letra) && letra!='/'){
                        if(!sb.isEmpty()){
                            tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex));
                            sb.setLength(0);
                        }
                        tokens.add(new Token_Model(""+letra, linhaIndex, colunaIndex+1));
                        continue;
                    } else{
                        if (letra==' ' || colunaIndex==linha.length()-1) {

                            if(colunaIndex==linha.length()-1 && letra!=' '){
                                sb.append(letra);
                            }
            
                            if(sb.isEmpty()){
                                continue;
                            } else{
                                tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex));
                                sb.setLength(0);
                            }
            
                        } else{
                            sb.append(letra);
                        }
                    }

                }


                linhaIndex++;
                linha = br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tokens;
    }
}