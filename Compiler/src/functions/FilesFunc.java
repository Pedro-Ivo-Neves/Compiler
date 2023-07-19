package functions;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import analysis.exception.LexicalException;
import constants.KeyWords;
import models.Token_Model;

public class FilesFunc {

    public static String programPath = ".\\docs\\programs\\";

    private String path;

    private BufferedReader br;
    
    public FilesFunc(String path){
        try {
            this.path = path;
            br = new BufferedReader(new FileReader(this.path));
        } catch (Exception e) {
            System.out.println("Erro no ficheiro ler ficheiro! Com o seguinte erro"+e.getMessage());
        }
    }

    public String fileParseToString(){
        try {
            br = new BufferedReader(new FileReader(this.path));
        } catch (FileNotFoundException e) {
            System.out.println("Erro no ficheiro ler ficheiro! Com o seguinte erro"+e.getMessage());
        }


        var fileInString = new StringBuilder();
        String linha;
        try {
            linha = br.readLine();
            while(linha!=null){

                if(!linha.matches("\\s*//.*")){
                    fileInString.append(linha+"\n");
                }

                linha = br.readLine();
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        
        String returnString = fileInString.toString();
        
        final Pattern pattern = Pattern.compile("/\\*(.|\\s*)*\\*/", Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(returnString);
        if(matcher.find()){
            returnString = matcher.replaceAll("");
        }
        
        System.out.println("Codigo: \n"+returnString);
        return returnString;
    }



    //? In this method it reads the file and captures each word
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



    //? In this method it reads character by character
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

                        //* Tentativa de comentario multiplo */
                        if(sb.length()>1 && sb.charAt(0)=='/'){

                            if(sb.length()==2){
                                if(letra == '*'){
                                    sb.append(letra);
                                    continue;
                                } else{
                                    continue;
                                }
                            }

                            if(sb.length()==3){
                                if(letra=='/'){
                                    sb.setLength(0);
                                    continue;
                                } else{
                                    sb.deleteCharAt(sb.length()-1);
                                }
                            }
                        }

                        //* Here we validate the comments in the file
                        if(sb.charAt(0)=='/'){
                            //* Comentario Simples */
                            if(letra=='/'){
                                sb.setLength(0);
                                break;

                            } else{

                                //* Inicio de comentario multiplo */
                                if(letra=='*'){
                                    sb.append(letra);
                                    continue;
                                }
                            }
                        }

                        //* Constantes Numericas */
                        if(KeyWords.constantesNumericas.contains(sb.charAt(0)+"")){
                            
                            if(sb.toString().matches("([0-9]*\\.[0-9]*){2,}")){
                                throw new LexicalException("Numero decimal invalido! [ Linha: "+linhaIndex+" , Coluna: "+colunaIndex+"]");
                            } else{
                                if(letra=='.'){
                                    sb.append(letra);
                                    continue;
                                }
                            }
                            
                        }

                        //* Here we validate the constants literary
                        if(sb.charAt(0)=='\"'){
                            
                            sb.append(letra);
                            
                            if(letra=='\"' && sb.length()>1){
                                tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex));
                                sb.setLength(0);
                            }
                            continue;
                        }
                    } 

                    if(KeyWords.constantesNumericas.contains(letra+"") && letra!='/' && sb.isEmpty()){
                        sb.append(letra);
                        continue;
                    }

                    
                    //* Catches a special symbol except the / characater
                    if(KeyWords.simbolosEspeciais.contains(""+letra) && letra!='/'){
                        if(!sb.isEmpty()){
                            tokens.add(new Token_Model(sb.toString(), linhaIndex, colunaIndex));
                            sb.setLength(0);
                        }
                        tokens.add(new Token_Model(""+letra, linhaIndex, colunaIndex+1));
                        continue;
                    } else{
                        // *If it gets to the end of the line or the letter is a space
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

            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tokens;
    }
}