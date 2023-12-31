package model.impl;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal {

    private static List<String> dogCommands = new ArrayList<>();

    
    public Dog(String type, String name, String age) {
        super(type, name, age);
    }
    public Dog() {}
    

    public void printDogCommands(){
        dogCommands.forEach(System.out::println);
    }

    public void addNewDogCommand(String newCom){
        dogCommands.add(newCom);
    }


}
