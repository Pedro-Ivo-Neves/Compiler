package models.Identifier;

public class Identifier_Model {

    static int id = 0;

    String name;
    Category_Enum category;
    Type_Enum type;
    String value;

    Identifier_Model(String name){
        this.id++;
        this.name = name;
    }


}
