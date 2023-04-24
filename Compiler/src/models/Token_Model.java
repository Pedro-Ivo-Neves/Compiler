package models;


public class Token_Model{

    private String token;
    private int lineIndex;
    private int columnIndex;
    private String typeToken;

    public Token_Model(String token, int lineIndex, int columnIndex){
        this.token = token;
        this.lineIndex = lineIndex;
        this.columnIndex = columnIndex;
    }

    public String getToken() {return this.token;}

    public int getLineIndex() {return this.lineIndex;}

    public int getColumnIndex() {return this.columnIndex;}

    protected Token_Model setTypeModel(String type){
        this.typeToken = type;
        return this;
    }

    public String getType(){return this.typeToken;}
}