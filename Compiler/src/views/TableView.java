package views;

import java.util.ArrayList;
import java.util.HashMap;

public class TableView {
    
    public TableView(){}

    public void MapView(HashMap<String, String> map){
        System.out.println("====================================");
        System.out.println("|    TOKEN    |    CLASSIFICACAO   |");
        System.out.println("====================================");
        
        map.forEach(
            (key, value)->{
                System.out.printf("|   %10s |   %15s  |", value, key);
            }
        );
        System.out.println("====================================");
    }

    public void ListView(ArrayList<String> list){

    }
}