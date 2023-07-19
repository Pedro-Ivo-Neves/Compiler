package analysis;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import analysis.exception.*;
import models.Token_Model;

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

        for (String token : this.tokens.stream().map(Token_Model::getToken).collect(Collectors.toList())) {
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

        
        //* Functions */
        String ParamsExp = "(\\(\\)|\\((int|float|String|char|double)\\s*"+NameExp+"(,{1}\\s*(int|float|String|char|double)\\s*"+NameExp+")*\\))";
        
        String FloatFuncExp = "";
        String IntFuncExp = "";
        String VoidFuncExp = "\\s*void{0,1}\\s*"+NameExp+"\\s*"+ParamsExp+"\\{\\}";
        String FunctionExp = "(public|private|protected){0,1}\\s*(final){0,1}\\s*("+VoidFuncExp+")\\s*";
        
        //* Declarations */
        String IntDeclareExp = "int\\s*"+NameExp+"(,"+NameExp+"|={1}([0-9]+|"+NameExp+"){1})*";
        String FloatDeclareExp = "float\\s*"+NameExp+"(,"+NameExp+"|={1}([0-9]+(\\.[0-9]+){0,1}|"+NameExp+"){1})*";
        
        String DeclarativeExp ="(public|private|protected){0,1}\\s*(final){0,1}\\s*("+IntDeclareExp+"|"+FloatDeclareExp+")\\s*;";
        
        //* Class Body */
        String ClassBodyExp = "(\\s|"+DeclarativeExp+"|"+FunctionExp+")";
        
        //* Classes */
        String ClassExp = "public\\s+class\\s+"+NameExp+"\\s*\\{"+ClassBodyExp+"*}\\s*";

        //* Final Regex */
        final String regex = "public\\s+class\\s+"+NameExp+"\\s*\\{"+ClassBodyExp+"*}\\s*";



        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(rawCode);
        
        if(matcher.matches()){
            System.out.println("Sucesso!");
        } else{
            throw new SintaticalException("Class has sintax error!");
        }
    }


}
