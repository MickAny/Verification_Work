package view;

import controller.AnimalController;
import java.util.Scanner;

public class View {

    public void ShowActions(){
        Scanner scanner = new Scanner(System.in);
        AnimalController animalController = new AnimalController();
        boolean mark = true;
        while(mark){
            printActions();
            switch(Integer.parseInt(scanner.nextLine())){
                case 1 -> animalController.createAnimal(); // +
                case 2 -> animalController.showAnimalCommands();
                case 3 -> animalController.addAnimalCommand();
                case 4 -> System.out.println("Общее кол-во животных: " + AnimalController.AnimalCounter.getCounter());
                case 5 -> animalController.showAnimals(); //+
                default -> mark = false;
            }
        }
    }

    private static void printActions() {
        String textBlock = """
                Available actions: 
                                
                0 - закончить работу
                                
                1 - завести новое животное
                                
                2 - увидеть список команд, которое выполняет животное (по типу)
                
                3 - обучить животное новым командам (по типу)
                
                4 - показать общее количество созданных животных (счетчик)
                
                5 - показать всех животных (по типу)
                                
                Введите номер желаемого действия:""";
        System.out.print(textBlock + " ");
    }
}
