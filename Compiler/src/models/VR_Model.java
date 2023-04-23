package models;

public class VR_Model extends Token_Model{

    private Object beforeToken;

    public VR_Model(String token, int lineIndex, int columIndex){
        super(token, lineIndex, columIndex);
    }

    public VR_Model setBeforeToken(Object beforeToken){
        if (beforeToken instanceof SE_Model || beforeToken instanceof PR_Model || beforeToken instanceof TP_Model) {
            this.beforeToken = beforeToken;
        } else {
            //TODO: Colocar uma messagem para a VR_Model Exception
        }

        return this;
    }
}
