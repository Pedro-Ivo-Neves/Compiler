package models;

public enum Token_Enum {
    
    PR("Palavra Reservada"),
    TP("Tipo primitivo"),
    // SE("Simbolo Especial"),

    DL("Delimitadores"),
    SL("Simbolos Logicos"),
    SN("Simbolos Numericos"),
    CN("Constantes Numericas"),
    CL("Constantes Logicas"),
    CLI("Constantes Literarias"),

    ID("Indicador");

    Token_Enum(String type){}
}
