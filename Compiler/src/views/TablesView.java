package views;

import java.util.LinkedList;

import models.Token_Model;

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
}