package model.impl;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {

    private static List<String> catCommands = new ArrayList<>();

    
    public Cat(String type, String name, String age) {
        super(type, name, age);
    }

    public Cat() {
        super();
    }

    
    public void printCatCommands(){
        catCommands.forEach(System.out::println);
    }

    public void addNewCatCommand(String newCom){
        catCommands.add(newCom);
    }
}
