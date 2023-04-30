package analysis;
import java.util.LinkedList;
import models.*;
import views.*;

public class LexicalAnalysis {
    
    private LinkedList<Token_Model> tokenList;

    public LexicalAnalysis(LinkedList<Token_Model> listaPalavras){
        this.tokenList = listaPalavras;
        lexicalMap();
    }

    private void lexicalMap(){

        tokenList.forEach((token)->{
            
            
        });
    }

    public void lexicalTable(){
        new TablesView().TokenTableView(this.tokenList);
    }
}
