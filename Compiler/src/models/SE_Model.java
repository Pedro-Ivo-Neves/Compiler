package models;

import analysis.exception.LexicalExcepction;

public class SE_Model extends PR_Model{

    private Object beforeToken;

    public SE_Model(String token, int lineIndex, int columIndex) {
        super(token, lineIndex, columIndex);
    }

    public SE_Model setBeforeToken(Object beforeToken){
        if (beforeToken instanceof VR_Model || beforeToken instanceof SE_Model || beforeToken instanceof TP_Model) {
            this.beforeToken = beforeToken;
        } else {
            //TODO: Colocar uma messagem para a SE_Model Exception
            throw new LexicalExcepction("");
        }
        return this;
    }
}
