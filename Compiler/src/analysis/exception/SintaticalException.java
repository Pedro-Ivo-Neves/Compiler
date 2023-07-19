package analysis.exception;

public class SintaticalException extends RuntimeException{
    public SintaticalException(){super();}

    public SintaticalException(String message){
        super("\n\u001B[33mSintax Error:\u001B[37m "+message);
    }
}