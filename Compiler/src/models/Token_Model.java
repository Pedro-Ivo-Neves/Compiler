package models;


public abstract class Token_Model{

    protected String token;
    protected int lineIndex;
    protected int columIndex;

    public Token_Model(String token, int lineIndex, int columIndex){
        this.token = token;
        this.lineIndex = lineIndex;
        this.columIndex = columIndex;
    }

    protected String getToken() {return this.token;}

    protected int getLineIndex() {return this.lineIndex;}

    protected int getColumIndex() {return this.columIndex;}
}