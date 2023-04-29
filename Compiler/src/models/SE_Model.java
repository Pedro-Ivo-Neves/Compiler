package models;

import analysis.exception.LexicalException;
import models.*;

public class SE_Model extends Token_Model{

    private Object beforeToken;

    public SE_Model(String token, int lineIndex, int columnIndex) {
        super(token, lineIndex, columnIndex);
        setTypeModel("SE");
    }

    public SE_Model(Token_Model tm){
        super(tm.getToken(), tm.getLineIndex(), tm.getColumnIndex());
        setTypeModel("SE");
    }

    public SE_Model setBeforeToken(Object beforeToken){
        if (beforeToken instanceof VR_Model || beforeToken instanceof SE_Model || beforeToken instanceof TP_Model) {
            this.beforeToken = beforeToken;
        } else {
            throw new LexicalException("Antes de um\033[32m Simbolo Especial\033[0m, espera-se uma \033[34mTP\033[0m ou um \033[36mVR\033[0m ou \033[32mSE\033[0m!\nA palavra: \033[31m"+super.getToken()+"\033[0m (linha:"+super.getLineIndex()+", coluna: "+super.getColumnIndex()+")");
        }
        return this;
    }
}
