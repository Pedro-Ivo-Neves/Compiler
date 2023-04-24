package analysis;
import java.util.ArrayList;
import java.util.regex.Pattern;

import analysis.exception.LexicalException;
import constants.*;
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

            int index =tokenList.indexOf(token);

            if (Pattern.compile("[^a-zA-Z0-9]").matcher(token.getToken()).find()) {

                if(KeyWords.simbolosEspeciais.contains(token.getToken())){
                    tokenList.set(index, new SE_Model(token).setBeforeToken(index==0 ? null : tokenList.get(index-1)));
                } 

            } else {
                if(KeyWords.tiposPrimitivos.contains(token.getToken())){
                    tokenList.set(index, new TP_Model(token).setBeforeToken(index==0 ? null : tokenList.get(index-1)));
                }

                else{
                    if (KeyWords.palavrasReservadas.contains(token.getToken())) {
                        tokenList.set(index, new PR_Model(token).setBeforeToken(index==0 ? null : tokenList.get(index-1)));
                    } else {
                        tokenList.set(index, new VR_Model(token).setBeforeToken(index==0 ? null : tokenList.get(index-1)));
                    }
                }
            }
        });
    }

    public void lexicalTable(){
        new TablesView().TokenTableView(this.tokenList);
    }
}
