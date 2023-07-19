package models.Identifier;

public class Identifier_Model {

    private String name;
    private Category_Enum category;
    private Type_Enum type;
    private Object value;

    

    public Identifier_Model(String name, Category_Enum category, Type_Enum type, Object value){
        this.name =name;
        this.category=category;

        if(type!=null){
            this.type=type;
            this.value=value;
        }

    }

    public Identifier_Model(String name){
        this.name=name;
    }
    
    public Identifier_Model setType(Type_Enum type){
        this.type = type;

        return this;
    }

    public Identifier_Model setValue(Object value){
        this.value = value;

        return this;
    }

    public Identifier_Model setCategory(Category_Enum category){
        this.category = category;
        return this;
    }

    //! Sim, pode ser feito de melhor forma
    


    //* GETTERS */

    public String getName() {
        return name;
    }

    public Category_Enum getCategory() {
        return category;
    }

    public Type_Enum getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
