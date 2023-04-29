package models;

public enum Token_Enum {
    
    PR("Palavra Reservada"),
    TP("Tipo primitivo"),
    SE("Simbolo Especial"),

    DL("Delimitadores"),
    SL("Simbolos Logicos"),
    CN("Constantes Naturais"),
    CL("Constantes Logicas"),
    CLI("Constantes Literarias");

    Token_Enum(String type){}
}
