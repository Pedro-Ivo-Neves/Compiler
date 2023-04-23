package models;

import analysis.exception.LexicalExcepction;

public class PR_Model extends Token_Model{

    private Object beforeToken;

    public PR_Model(String token, int lineIndex, int columIndex){
        super(token, lineIndex, columIndex);
    }
    
    public PR_Model setBeforeToken(Object beforeToken){

        if (beforeToken instanceof PR_Model || beforeToken instanceof SE_Model) {
            this.beforeToken = beforeToken;
        } else {
            //TODO: Colocar uma messagem para a PR_Model Exception
            throw new LexicalExcepction("");
        }
        return this;
    }
}