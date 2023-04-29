package analysis;
import java.util.ArrayList;
import models.*;
import views.*;

public class LexicalAnalysis {
    
    private ArrayList<Token_Model> tokenList;

    public LexicalAnalysis(ArrayList<Token_Model> listaPalavras){
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
