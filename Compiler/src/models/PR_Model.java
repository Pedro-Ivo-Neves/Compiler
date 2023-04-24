package models;

import analysis.exception.LexicalException;

public class PR_Model extends Token_Model{

    private Object beforeToken;

    public PR_Model(String token, int lineIndex, int columnIndex){
        super(token, lineIndex, columnIndex);
        setTypeModel("PR");
    }

    public PR_Model(Token_Model tm){
        super(tm.getToken(), tm.getLineIndex(), tm.getColumnIndex());
        setTypeModel("PR");
    }
    
    public PR_Model setBeforeToken(Object beforeToken){

        if (beforeToken instanceof PR_Model || beforeToken instanceof SE_Model || beforeToken == null) {
            this.beforeToken = beforeToken;
        } else {
            throw new LexicalException("Antes de uma\033[33m Palavra Primitiva\033[0m, espera-se uma \033[33mPR\033[0m ou um \033[32mSE\033[0m! \nA palavra: \033[31m"+super.getToken()+"\033[0m (linha:"+super.getLineIndex()+", coluna: "+super.getColumnIndex()+")");
        }
        return this;
    }
}