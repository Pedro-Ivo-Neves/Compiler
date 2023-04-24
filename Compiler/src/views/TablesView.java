package views;

import java.util.ArrayList;

import models.Token_Model;

public class TablesView {
    
    public TablesView(){}

    public void TokenTableView(ArrayList<Token_Model> tokens){
        System.out.println("====================================");
        System.out.println("|    \033[36mTOKEN\033[0m    |    \033[35mCLASSIFICACAO\033[0m   |");
        System.out.println("====================================");
        
        tokens.forEach((token)->{
            System.out.printf("| %10s  |    %8s        |", token.getToken(), token.getType());
            System.out.println();
        });

        System.out.println("====================================");
    }
}