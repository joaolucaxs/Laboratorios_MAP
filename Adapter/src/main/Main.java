package main;

import adapters.ListToMap;
import adapters.MapToList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ListToMap<>(new HashMap<>());

        System.out.println("\nList to map: Adaptando a interface Map para a interface List\n");

        System.out.println("Adaptando o add");
        list.add("Gabriel");
        list.add("João");
        list.add(1, "Maria");
        //list.add(2, "Josenelle");
        list.forEach(System.out::println);
        
        System.out.println("");
        System.out.println("Adaptando o size");
        System.out.println(list.size());

        System.out.println("");
        System.out.println("Adaptando o get");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2)); 
        //System.out.println(list.get(3));


        System.out.println("");
        System.out.println("Adaptando o remove");
        System.out.println(list.remove("Maria"));
        System.out.println("Maria Deletada!");

        System.out.println("");
        System.out.println("Adaptando o toArray");

        for (String s : list.toArray(new String[0])) {
            System.out.println(s);
        }
 
        System.out.println("");
        System.out.println("Adaptando o contains");
        System.out.println(list.contains("Maria")); 
        System.out.println("Maria foi Deletada!");
        System.out.println(list.contains("João"));
        System.out.println("João está contido!");

  
        System.out.println("");
        System.out.println("Adaptando o clear");
        list.clear();
        System.out.println("Clear!");
        
        System.out.println("");
        System.out.println("Adaptando o isEmpty");
        System.out.println(list.isEmpty());
        System.out.println("Empty!");


        Map<String, String> map = new MapToList<>(new ArrayList<>());
        System.out.println("\nMap to list: Adaptando a interface List para a interface Map\n");

        System.out.println("");
        System.out.println("Adaptando o put");
        System.out.println(map.put("1", "João"));
        System.out.println(map.put("2", "Josenelle"));

        System.out.println("");
        System.out.println("Adaptando o get");
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));

        System.out.println("");
        System.out.println("Adaptando o containsValue");
        System.out.println(map.containsValue("João"));
        
        System.out.println("");
        System.out.println("Adaptando o containsKey");
        System.out.println(map.containsKey("2"));

        System.out.println("");
        System.out.println("Adaptando o values");
        map.values().forEach(System.out::println);

        System.out.println("");
        System.out.println("Adaptando o isEmpty");
        System.out.println(map.isEmpty());

        System.out.println("");
        System.out.println("Adaptando o remove");
        System.out.println(map.remove("1"));

        System.out.println("");
        System.out.println("Adaptando o size");
        System.out.println(map.size());

        System.out.println("");
        System.out.println("Adaptando o clear");
        map.clear();
        System.out.println("Clear!");

    }
}
