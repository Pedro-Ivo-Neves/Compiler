package constants;

import functions.*;
import java.util.*;

public class KeyWords{
    
    public static ArrayList<String> palavrasReservadas;
    public static ArrayList<String> tiposPrimitivos;
    public static ArrayList<String> simbolosEspeciais;

    public static ArrayList<String> simbolosLogoicos;
    public static ArrayList<String> simbolosNumericos;
    public static ArrayList<String> delimitadores;
    public static ArrayList<String> constantesNumericas;

    public static ArrayList<String> constantesLogicas = new ArrayList<>(2);
    

    public KeyWords(){
        palavrasReservadas = listFromFile("PR", ",");
        tiposPrimitivos = listFromFile("TP", ",");
        simbolosEspeciais = listFromFile("SE", "_");

        simbolosLogoicos = listFromFile("SL", ",");
        simbolosNumericos = listFromFile("SN", ",");
        delimitadores = listFromFile("DL", "_");
        constantesNumericas = listFromFile("CN", ",");

        constantesLogicas.add("true");
        constantesLogicas.add("false");
    }

    private ArrayList<String> listFromFile(String fileName, String separador){
        return new FilesFunc(".\\docs\\classificacao\\"+fileName+".txt").readFile(separador);
    } 
}