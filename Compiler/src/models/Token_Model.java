package models;

import constants.KeyWords;

public class Token_Model{

    protected String token;
    protected int lineIndex;
    protected int columnIndex;
    protected Token_Enum typeToken;

    public Token_Model(String token, int lineIndex, int columnIndex){
        this.token = token;
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex-token.length();
        setTypeModel();
    }

    public String getToken() {return this.token;}

    public int getLineIndex() {return this.lineIndex;}

    public int getColumnIndex() {return this.columnIndex;}

    public Token_Enum getType(){return this.typeToken;}

    private Token_Model setTypeModel(){
        
        if(KeyWords.simbolosEspeciais.contains(this.token)){
            if (KeyWords.simbolosLogoicos.contains(this.token)) {
                this.typeToken = Token_Enum.SL;
            } 

            if(KeyWords.simbolosNumericos.contains(this.token)){
                this.typeToken = Token_Enum.SN;
            }

            if(KeyWords.delimitadores.contains(this.token)){
                this.typeToken = Token_Enum.DL;
            }
        } else{
            if (KeyWords.tiposPrimitivos.contains(this.token)) {
                this.typeToken = Token_Enum.TP;
            } else{
                if(KeyWords.palavrasReservadas.contains(this.token)){
                    this.typeToken = Token_Enum.PR;
                } else{
                    if(KeyWords.constantesLogicas.contains(this.token)){
                        this.typeToken = Token_Enum.CL;
                    } else{
                        if(KeyWords.constantesNumericas.contains(this.token)){
                            this.typeToken = Token_Enum.CN;
                        } else{
                            if(this.token.charAt(0)=='"' && this.token.charAt(this.token.length()-1)=='\"'){
                                this.typeToken = Token_Enum.CLI;
                            } else{
                                this.typeToken = Token_Enum.ID;
                            }
                        }
                    }
                }
            }

            
        }

        return this;
    }
}