package models;

import analysis.exception.LexicalExcepction;

public class TP_Model extends Token_Model{

    private Object beforeToken;

    public TP_Model(String token, int lineIndex, int columIndex){
        super(token, lineIndex, columIndex);
    }

    public TP_Model setBeforeToken(Object beforeToken){
        if(beforeToken instanceof PR_Model || beforeToken instanceof SE_Model){
            this.beforeToken = beforeToken;
        } else{
            throw new LexicalExcepction("Antes de um \033[34mTipo Primitivo\033[0m, espera-se uma \033[33mPR\033[0m ou uma \033[32mSE\033[0m! (linha:"+super.getLineIndex()+", coluna: "+super.getColumIndex()+")");
        }
        return this;
    }
}
