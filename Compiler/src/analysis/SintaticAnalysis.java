package analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.lang.model.element.Name;

import analysis.exception.*;
import models.Token_Enum;
import models.Token_Model;
import models.Identifier.Type_Enum;

public class SintaticAnalysis {
    
    private LinkedList<Token_Model> tokens;
    private String rawCode;

    SintaticAnalysis(LinkedList<Token_Model> tokens, String rawCode){
        this.tokens = tokens;
        this.rawCode = rawCode;

        /*
        *   Balanceamento de {}
        *   Balanceamento de ()
        *   
        */

        this.checkBalancedBrackets('{','}');
        this.checkBalancedBrackets('(', ')');
        System.out.println("\n-------Test-------");
        this.checkClass();
    }

    public void checkBalancedBrackets(char c, char d){

        var stack = new Stack<String>();

        for (String token : this.tokens.stream()
                            .filter(
                                tk -> tk.getType()!=Token_Enum.CLI
                                )
                            .map(Token_Model::getToken)
                            .collect(Collectors.toList())
            ) {
            if(token.equals(c+"")){
                stack.push(c+"");
            }

            else{
                if(token.equals(d+"")){
                    if(stack.isEmpty()){
                        throw new SintaticalException("Numero de '"+d+"' a mais do que esperado!");
                    }
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            throw new SintaticalException("Um '"+c+"' , pobre coitado ficou sem par para balancear!");
            // throw new SintaticalException("Numero de '"+c+d+"' invalido!");
        }

        // String n = stack.isEmpty() ? "Simm!" : "Nao!";
        // System.out.println("Pilha Vazia? "+n);
    }

    public void checkClass(){
        String NameExp = "[A-Za-z]\\w*";

        String ScopeExp = "(public|private|protected){0,1}\\s*(final){0,1}\\s*";

        
        //* Functions */
        String ParamsExp = "(\\(\\)|\\((int|float|String|char|double)\\s*"+NameExp+"(,{1}\\s*(int|float|String|char|double)\\s*"+NameExp+")*\\))";
        
        String FloatFuncExp = "\\s*float\\s*"+NameExp+"\\s*"+ParamsExp+"\\s*\\{\\s*(return\\s*([0-9]+(\\.[0-9]+){0,1}|"+NameExp+")\\s*;){1}\\s*\\}";
        String IntFuncExp = "\\s*int\\s*"+NameExp+"\\s*"+ParamsExp+"\\s*\\{\\s*(return\\s*([0-9]+|"+NameExp+")\\s*;){1}\\s*\\}";
        String VoidFuncExp = "\\s*void{0,1}\\s*"+NameExp+"\\s*"+ParamsExp+"\\s*\\{\\s*(return\\s*;){0,1}\\s*\\}";
        
        String FunctionExp = ScopeExp+"("+VoidFuncExp+"|"+IntFuncExp+"|"+FloatFuncExp+")\\s*";
        
        
        
        //* Declarations */
        
        //! Ainda Nao funciona !/
        String VarQualquerExp = "ex: n=2; |  this.l = 3;";
        String StringDeclareExp = "String\\s*[A-Za-z]\\w*\\s*(,[A-Za-z]\\w*|\\={1}\\s*(\".\"|[A-Za-z]\\w*){1})*\\s*;";
        String CharDeclareExp = "char\\s*"+NameExp+"\\s*(,\\s*"+NameExp+"|\\={1}\\s*(\\'([^']|\\\\\\')\\'|"+NameExp+"){1})*\\s*;";
        
        //* Funciona! */
        String IntDeclareExp = "int\\s*"+NameExp+"\\s*(,\\s*"+NameExp+"|\\={1}\\s*([0-9]+|"+NameExp+"){1})*";
        String FloatDeclareExp = "float\\s*"+NameExp+"\\s*(,\\s*"+NameExp+"|\\={1}\\s*([0-9]+(\\.[0-9]+){0,1}|"+NameExp+"){1})*";

        String DeclarativeExp = ScopeExp+"("+IntDeclareExp+"|"+FloatDeclareExp+"|"+CharDeclareExp+"|"+StringDeclareExp+")\\s*;";
    

        
        
        //* Classes */
        String ClassExp = "("+ScopeExp+"class\\s+"+NameExp+"\\s*\\{(\\s|"+DeclarativeExp+"|"+FunctionExp+")*}\\s*)*";
        

        //* Final Regex */
        final String regex = "("+ScopeExp+"class\\s+"+NameExp+"\\s*\\{(\\s|"+DeclarativeExp+"|"+FunctionExp+"|"+ClassExp+")*}\\s*)+";



        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(rawCode);
        
        if(matcher.matches()){
            System.out.println("Sucesso!");
        } else{
            throw new SintaticalException("Class has sintax error!");
        }
    }



}
