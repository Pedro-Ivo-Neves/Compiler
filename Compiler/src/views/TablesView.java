package views;

import java.util.LinkedList;

import models.Token_Model;
import models.Identifier.Identifier_Model;

public class TablesView {
    
    public TablesView(){}

    public void TokenTableView(LinkedList<Token_Model> tokens){
        System.out.println("=======================================================================");
        System.out.println("|    \033[36mTOKEN\033[0m    |    \033[35mCLASSIFICACAO\033[0m   |    \033[32mNr Linha\033[0m    |    \033[31mNr Coluna\033[0m    |");
        System.out.println("=======================================================================");
        
        tokens.forEach((token)->{
            System.out.printf("| %10s  |    %8s        |    %5d       |     %5d       |", token.getToken(), token.getType().name(),token.getLineIndex(), token.getColumnIndex());
            System.out.println();
        });

        System.out.println("=======================================================================");
    }

    public void TokenTableIDView(LinkedList<Identifier_Model> ids){
        System.out.println("===========================================================");
        System.out.println("|    \033[36mTOKEN\033[0m    |    \033[35mCATEGORIA\033[0m   |    \033[32mTIPO\033[0m    |    \033[31mVALUE\033[0m    |");
        System.out.println("===========================================================");

        ids.forEach(id->{
            String category= id.getCategory()==null?"---":id.getCategory()+"";
            String type = id.getType()==null?"---": id.getType()+"";
            String value = id.getValue()==null?"---":id.getValue()+"";

            System.out.printf("| %10s  |    %5s        |    %5s     |   %3s    |", id.getName(), category,type, value);
            System.out.println();
        });
        System.out.println("===========================================================");
    }
}