package models.Identifier;

public enum Type_Enum {
    
    STR("String"),
    CHAR("char"),
    INT("int"),
    DOUBLE("double"),
    FLOAT("float"),
    LONG("long"),
    BOOL("boolean"),
    VOID("void") //? Only for FUNC
    ;

    Type_Enum(String type){}
}
