package analysis;
import java.util.LinkedList;

import functions.FilesFunc;
import models.*;
import models.Identifier.Identifier_Model;
import views.*;

public class LexicalAnalysis {
    
    private LinkedList<Token_Model> tokenList;

    private LinkedList<Identifier_Model> identifier_Models;

    private FilesFunc filesFunc;

    public LexicalAnalysis(String path){
        filesFunc = new FilesFunc(path);
        this.tokenList = filesFunc.readCode();
        this.identifier_Models = new LinkedList<>();
    }

    public LexicalAnalysis lexicalTable(){
        new TablesView().TokenTableView(this.tokenList);
        return this;
    }

    public LexicalAnalysis identifierList(){
        int index = 0;

        for (Token_Model token : this.tokenList) {
            
            if(token.getType() == Token_Enum.ID){

                if(this.identifier_Models.stream().anyMatch(ID-> ID.getName().equals(token.getToken()))){
                    
                    System.out.println("Ja foi chamado");
                } else{
                    this.identifier_Models.add(
                        new Identifier_Model(token.getToken())
                        .setTokenAntesAnterior(this.tokenList.get(index-2))
                        .setTokenAnterior(this.tokenList.get(index-1))
                        .setTokenPosterior(this.tokenList.get(index+1))
                        .setTokenDepoisPosterior(this.tokenList.get(index+2))
                        .setAll()
                    );
                }
            }

            index++;
        }

        this.identifier_Models.forEach(id -> System.out.println("Nome: "+id.getName()+"\nCategoria: "+id.getCategory()));

        return this;
    }

    public LexicalAnalysis sintaticAnalise(){

        new SintaticAnalysis(this.tokenList, this.filesFunc.fileParseToString());

        return this;
    }
}
