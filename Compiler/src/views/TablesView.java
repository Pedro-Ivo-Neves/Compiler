package views;

import java.util.ArrayList;

public class TablesView {
    
    public TablesView(){}

    public void TokenTableView(ArrayList<String> token, ArrayList<String> classification){
        System.out.println("====================================");
        System.out.println("|    \033[36mTOKEN\033[0m    |    \033[35mCLASSIFICACAO\033[0m   |");
        System.out.println("====================================");
        
        for (int i = 0; i < token.size(); i++) {
            System.out.printf("| %10s  |    %8s        |", token.get(i), classification.get(i));
            System.out.println();
        }
        System.out.println("====================================");
    }
}