package analysis;
import java.util.ArrayList;
import java.util.regex.Pattern;

import analysis.exception.LexicalExcepction;
import constants.*;
import views.*;

public class LexicalAnalysis {
    
    private ArrayList<String> tokenList;
    private ArrayList<String> classificationList;
    private KeyWords keyWords;


    public LexicalAnalysis(ArrayList<String> listaPalavras){
        this.tokenList = listaPalavras;
        this.classificationList = new ArrayList<String>();
        this.keyWords = new KeyWords();
        lexicalMap();
    }

    private void lexicalMap(){

        tokenList.forEach((token)->{

            
            if (Pattern.compile("[^a-zA-Z0-9]").matcher(token).find()) {
                
                if(keyWords.simbolosEspeciais.contains(token)){
                    classificationList.add("SE");
                } else{
                    throw new LexicalExcepction("O simbolo \033[31m"+token+"\033[0m nao pertence");
                }

            } else {
                if(keyWords.tiposPrimitivos.contains(token)){
                    classificationList.add("TP");
                }

                else{
                    if (keyWords.palavrasReservadas.contains(token)) {
                        classificationList.add("PR");
                    } else {
                        classificationList.add("VR");
                    //    throw new LexicalExcepction("A palavra \033[31m"+token+"\033[0m nao pertence");
                    }
                }
            }
        });
    }

    public void lexicalTable(){
        new TablesView().TokenTableView(this.tokenList, this.classificationList);
    }
}
