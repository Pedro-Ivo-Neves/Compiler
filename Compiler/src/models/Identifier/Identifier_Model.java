package models.Identifier;

import models.Token_Enum;
import models.Token_Model;

public class Identifier_Model {

    static int id = 0;

    private String name;
    private Category_Enum category;
    private Type_Enum type;
    private Object value;

    private Token_Model token_antes_anterior;
    private Token_Model token_anterior;
    private Token_Model token_posterior;
    private Token_Model token_depois_posterior;

    public Identifier_Model(String name){
        Identifier_Model.id++;
        this.name = name;
    }
    
    public Identifier_Model setAll(){
        if(this.token_anterior.getToken().equals("class")){
            //* Class
            this.category = Category_Enum.CLASS;
        } else{
            if(this.token_anterior.getType() == Token_Enum.TP){
                if(this.token_posterior.getToken().equals("(")){
                    //* Function
                    this.category = Category_Enum.FUNC;

                } else{
                    
                    if(this.token_antes_anterior.getToken().equals("(")){
                        //* Primeiro parametro
                        this.category = Category_Enum.PARAM;
                    }


                    else{
                        if(this.token_antes_anterior.getToken().equals("final")){
                            //* Constante */
                            this.category = Category_Enum.CONST;
                        } else{
                            //* Variable
                            this.category = Category_Enum.VAR;
                        }
                    }
                    
                }
            }
        }
        return this;
    }

    public Identifier_Model setValue(){

        if(this.category == Category_Enum.CLASS){

        }


        return this;
    }

    public Identifier_Model setCategory(Category_Enum category){
        this.category = category;
        return this;
    }


    //! Sim, pode ser feito de melhor forma
    
    public Identifier_Model setTokenAntesAnterior(Token_Model token){
        this.token_antes_anterior = token;
        return this;
    }

    public Identifier_Model setTokenAnterior(Token_Model token){
        this.token_anterior = token;
        return this;
    }

    public Identifier_Model setTokenPosterior(Token_Model token){
        this.token_posterior = token;
        return this;
    }


    public Identifier_Model setTokenDepoisPosterior(Token_Model token){
        this.token_depois_posterior = token;
        return this;
    }


    //* GETTERS */

    public static int getId() {
        return id;
    }

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

    public Token_Model getToken_anterior() {
        return token_anterior;
    }

    public Token_Model getToken_posterior() {
        return token_posterior;
    }
}
