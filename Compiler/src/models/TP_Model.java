package models;

import analysis.exception.LexicalException;

public class TP_Model extends Token_Model{

    private Object beforeToken;

    public TP_Model(String token, int lineIndex, int columnIndex){
        super(token, lineIndex, columnIndex);
        setTypeModel("TP");
    }

    public TP_Model(Token_Model tm){
        super(tm.getToken(), tm.getLineIndex(), tm.getColumnIndex());
        setTypeModel("TP");
    }

    public TP_Model setBeforeToken(Object beforeToken){
        if(beforeToken instanceof PR_Model || beforeToken instanceof SE_Model){
            this.beforeToken = beforeToken;
        } else{
            throw new LexicalException("Antes de um \033[34mTipo Primitivo\033[0m, espera-se uma \033[33mPR\033[0m ou um \033[32mSE\033[0m! \nA palavra: \033[31m"+super.getToken()+"\033[0m (linha:"+super.getLineIndex()+", coluna: "+super.getColumnIndex()+")");
        }
        return this;
    }
}
