package model.impl;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Hamster extends Animal {

    private static List<String> hamsterCommands = new ArrayList<>();

    
    public Hamster(String type, String name, String age) {
        super(type, name, age);
    }

    public Hamster() {
        super();
    }

    
    public void printHamsterCommands(){
        hamsterCommands.forEach(System.out::println);
    }

    public void addNewHamsterCommand(String newCom){
        hamsterCommands.add(newCom);
    }

}
