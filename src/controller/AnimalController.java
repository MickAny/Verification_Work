package controller;

import model.Animal;
import model.impl.Cat;
import model.impl.Dog;
import model.impl.Hamster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalController {
    Scanner scanner = new Scanner(System.in);
    private final static List<Cat> cats = new ArrayList<>();
    private final static List<Dog> dogs = new ArrayList<>();
    private final static List<Hamster> hamsters = new ArrayList<>();



    public void createAnimal(){

        System.out.println("Введите тип животного(cat, dog, hamster)");
        String tempType = scanner.nextLine();
        System.out.println("Введите имя животного");
        String tempName = scanner.nextLine();
        System.out.println("Введите возраст животного");
        String tempAge = scanner.nextLine();


        switch (tempType.toLowerCase()){
            case "cat" -> {
                Cat tempCat = new Cat(tempType, tempName, tempAge);
                addAnimal(tempCat);
                AnimalCounter.counterIncrement();
            }
            case "dog" -> {
                Dog tempDog = new Dog(tempType, tempName, tempAge);
                addAnimal(tempDog);
                AnimalCounter.counterIncrement();
            }
            case "hamster" -> {
                Hamster tempHamster = new Hamster(tempType, tempName, tempAge);
                addAnimal(tempHamster);
                AnimalCounter.counterIncrement();
            }
            default -> System.out.println("Вы ввели неверный тип. Попробуйте еще раз");
        }


        System.out.printf("Животное типа %s, с именем %s и возрастом %s было успешно добавлено в список\n"
                .formatted(tempType, tempName, tempAge));

    }
    private void addAnimal(Animal animal){

        var Class = animal.getClass();

        if (Class.equals(Cat.class)) {
            cats.add((Cat) animal);
        } else if (Class.equals(Dog.class)) {
            dogs.add((Dog) animal);
        } else {
            hamsters.add((Hamster) animal);
        }
    }

    public void showAnimalCommands(){

        System.out.println("Введите тип животного: ");
        String type = scanner.nextLine();
        switch (type.toLowerCase()){
            case "cat" -> {
                Cat tempCat = new Cat();
                System.out.println("Список команд котов: ");
                tempCat.printCatCommands();
            }
            case "dog" -> {
                Dog tempDog = new Dog();
                System.out.println("Список команд собак: ");
                tempDog.printDogCommands();
            }
            case "hamster" -> {
                Hamster tempHamster = new Hamster();
                System.out.println("Список команд хомяков: ");
                tempHamster.printHamsterCommands();
            }
            default -> System.out.println("Такого типа не существует");
        }
    }

    public void addAnimalCommand(){

        System.out.println("Введите тип животного: ");
        String type = scanner.nextLine();
        switch (type.toLowerCase()){
            case "cat" -> {
                Cat tempCat = new Cat();
                System.out.println("Введите новую команду");
                String tempCommand = scanner.nextLine();
                tempCat.addNewCatCommand(tempCommand);
                System.out.printf("Команда '%s' была успешно добавлена\n".formatted(tempCommand));
            }
            case "dog" -> {
                Dog tempDog = new Dog();
                System.out.println("Введите новую команду");
                String tempCommand = scanner.nextLine();
                tempDog.addNewDogCommand(tempCommand);
                System.out.printf("Команда '%s' была успешно добавлена\n".formatted(tempCommand));
            }
            case "hamster" -> {
                Hamster tempHamster = new Hamster();
                System.out.println("Введите новую команду");
                String tempCommand = scanner.nextLine();
                tempHamster.addNewHamsterCommand(tempCommand);
                System.out.printf("Команда '%s' была успешно добавлена\n".formatted(tempCommand));
            }
            default -> System.out.println("Такого типа не существует");
        }
    }


    public void showAnimals(){
        System.out.println("Введите тип животного: ");
        String type = scanner.nextLine();
        switch (type.toLowerCase()){
            case "cat" -> cats.forEach(System.out::println);
            case "dog" -> dogs.forEach(System.out::println);
            case "hamster" -> hamsters.forEach(System.out::println);
            default -> System.out.println("Такого типа не существует");
        }
    }

    public static class AnimalCounter {

        static int counter = 0;

        public static void counterIncrement(){
            counter++;
        }

        public static int getCounter() {
            return counter;
        }
    }

}

