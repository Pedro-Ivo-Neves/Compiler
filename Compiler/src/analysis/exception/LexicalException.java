package analysis.exception;

public class LexicalException extends Error{
    
    public LexicalException(){
        super();
    }

    public LexicalException(String message){
        super("\n\u001B[35mLexical Error:\u001B[37m "+message);
    }
}