package analysis;
import java.util.LinkedList;
import java.util.stream.Collectors;

import functions.FilesFunc;
import models.*;
import models.Identifier.Category_Enum;
import models.Identifier.Identifier_Model;
import models.Identifier.Type_Enum;
import views.*;

public class LexicalAnalysis {
    
    private LinkedList<Token_Model> tokenList;

    private LinkedList<Identifier_Model> identifier_Models;

    private  int index = 0;

    private  int Nrparams = 0;


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

        // for (Token_Model token : this.tokenList) {
            
        //     if(token.getType() == Token_Enum.ID){

        //         if(this.identifier_Models.stream().anyMatch(ID-> ID.getName().equals(token.getToken()))){
                    
        //             System.out.println("Ja foi chamado");
        //         } else{
        //             this.identifier_Models.add(
        //                 new Identifier_Model(token.getToken())
        //                 .setTokenAntesAnterior(this.tokenList.get(index-2))
        //                 .setTokenAnterior(this.tokenList.get(index-1))
        //                 .setTokenPosterior(this.tokenList.get(index+1))
        //                 .setTokenDepoisPosterior(this.tokenList.get(index+2))
        //                 .setAll()
        //             );
        //         }
        //     }

        //     index++;
        // }

        this.tokenList.forEach(
            tk->{
                
                if(tk.getType()==Token_Enum.ID){
                    Category_Enum category=null;
                    Type_Enum type=null;
                    Object value=null;
                 
                 
                    if(Nrparams>0){
                        Nrparams--;
                    } else{

                        if(this.tokenList.get(index-1).getToken().equals("class")){
                                //* Class
                                category = Category_Enum.CLASS;
                                value = "---";
                        } else{
                            if(this.tokenList.get(index-1).getType() == Token_Enum.TP){
                                if(this.tokenList.get(index+1).getToken().equals("(")){
                                    //* Function
                                    category = Category_Enum.FUNC;
                                    if(this.tokenList.get(index-1).getToken().equals("int")){
                                        type = Type_Enum.INT;
                                    } else{
                                        type = Type_Enum.FLOAT;
                                    }
                                } else{
                                    
                                    //*Parametro
                                    if(this.tokenList.get(index-2).getToken().equals("(")){
                                        
                                        for (Token_Model params : this.tokenList.stream().filter(token->token.getType()==Token_Enum.ID).collect(Collectors.toList())) {
                                            category = Category_Enum.PARAM;
                                            if(this.tokenList.get(index+1).getToken().equals(")")){
                                                if(this.tokenList.get(index-1).getToken().equals("int")){
                                                    type = Type_Enum.INT;
                                                } else{
                                                    type = Type_Enum.FLOAT;
                                                }
                                                break;
                                            } else{
                                                if(this.tokenList.get(index-1).getToken().equals("int")){
                                                    type = Type_Enum.INT;
                                                } else{
                                                    type = Type_Enum.FLOAT;
                                                }
                                            }
    
                                            Nrparams++;
                                        }
                                    }
                
                
                                    else{
                                        if(this.tokenList.get(index-2).getToken().equals("final")){
                                            //* Constante */
                                            category = Category_Enum.CONST;
                                            if(this.tokenList.get(index-1).getToken().equals("int")){
                                                type = Type_Enum.INT;
                                            } else{
                                                type = Type_Enum.FLOAT;
                                            }
                                            
                                        } else{
                                            //* Variable
                                            category = Category_Enum.VAR;
                                            if(this.tokenList.get(index-1).getToken().equals("int")){
                                                type = Type_Enum.INT;
                                            } else{
                                                type = Type_Enum.FLOAT;
                                            }
                                        }
    
                                        if(this.tokenList.get(index+1).getToken().equals("=")){
                                            value = this.tokenList.get(index+2).getToken();
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }

                    if(category==null ||type==null || value==null){
                        if(category!=null){

                            var id= new Identifier_Model(tk.getToken());
    
                            if(type!=null){
                                id.setType(type);
                            }
    
                            if(value!=null){
                                id.setValue(value);
                            }
    
                            this.identifier_Models.add(id);
                        }
                    } else{

                        this.identifier_Models.add(new Identifier_Model(tk.getToken(), category, type, value));
                    }


                }

                this.index++;
            }
        );

        // this.identifier_Models.forEach(id -> System.out.println("Nome: "+id.getName()+"\nCategoria: "+id.getCategory()+"\nType:"+id.getType()+"\nValue: "+id.getValue()+"\n"));
        new TablesView().TokenTableIDView(this.identifier_Models);
        return this;
    }

    public LexicalAnalysis sintaticAnalise(){

        new SintaticAnalysis(this.tokenList, this.filesFunc.fileParseToString());

        return this;
    }
}
