package constants;

import functions.*;
import java.util.ArrayList;

public class KeyWords{
    
    public static ArrayList<String> palavrasReservadas = new ArrayList<String>();
    public static ArrayList<String> tiposPrimitivos = new ArrayList<>();
    public static ArrayList<String> simbolosEspeciais = new ArrayList<>();

    public KeyWords(){
        palavrasReservadas.addAll(new Ficheiro(".\\docs\\classificacao\\PR.txt").lerficheiro(","));
        tiposPrimitivos.addAll(new Ficheiro(".\\docs\\classificacao\\TP.txt").lerficheiro(","));
        simbolosEspeciais.addAll(new Ficheiro(".\\docs\\classificacao\\SE.txt").lerficheiro("_"));
    }
}