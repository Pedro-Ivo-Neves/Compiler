package analysis.exception;

public class LexicalExcepction extends RuntimeException{
    
    public LexicalExcepction(){
        super();
    }

    public LexicalExcepction(String message){
        super("\u001B[35mLexical Error:\u001B[37m "+message);
    }
}