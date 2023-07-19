package models;

public enum Token_Enum {
    
    PR("Palavra Reservada"),
    TP("Tipo primitivo"),
    // SE("Simbolo Especial"),

    DL("Delimitadore"),
    SL("Simbolo Logico"),
    SN("Simbolo Numerico"),
    CN("Constante Numerica"),
    CNF("Contante Numerica Flotoante"),
    CL("Constante Logicas"),
    CLI("Constante Literaria"),

    ID("Indicador");

    Token_Enum(String type){}
}
