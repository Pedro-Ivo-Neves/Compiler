package models;

import analysis.exception.LexicalExcepction;

public class VR_Model extends Token_Model{

    private Object beforeToken;

    public VR_Model(String token, int lineIndex, int columnIndex){
        super(token, lineIndex, columnIndex);
        setTypeModel("VR");
    }
    public VR_Model(Token_Model tm){
        super(tm.getToken(), tm.getLineIndex(), tm.getColumnIndex());
        setTypeModel("VR");
    }

    public VR_Model setBeforeToken(Object beforeToken){
        if (beforeToken instanceof SE_Model || beforeToken instanceof PR_Model || beforeToken instanceof TP_Model) {
            this.beforeToken = beforeToken;
        } else {
            throw new LexicalExcepction("Antes de uma\033[32m Variavel\033[0m, espera-se uma \033[33mPR\033[0m ou um \033[34mTP\033[0m ou \033[32mSE\033[0m!\nA palavra: \033[31m"+super.getToken()+"\033[0m (linha:"+super.getLineIndex()+", coluna: "+super.getColumnIndex()+")");
        }

        return this;
    }
}
