package by.epam.training.jwd.task04.client.view.impl;

import by.epam.training.jwd.task04.bean.impl.composite.Text;
import by.epam.training.jwd.task04.client.resource_manager.ResourceManager;
import by.epam.training.jwd.task04.client.view.View;

import java.util.Scanner;

import static by.epam.training.jwd.task04.client.view.properties.ViewParameter.*;


public class ConsoleView implements View {

    private Scanner scanner;
    private static ResourceManager manager = ResourceManager.getInstance();

    public ConsoleView(){
        scanner = new Scanner(System.in);
    }


    public void showResponse(Text response){
        System.out.println(response.getContent());
    }


    public void showTaskOptions() {
        String options = String.format("\n0)%s\n1)%s\n2)%s\n3)%s\n4)%s\n5)%s\n6)%s\n7)%s\n8)%s\n9)%s\n10)%s\n11)%s\n12)%s\n" +
                "13)%s\n14)%s\n15)%s\n16)%s\n99)%s\n", manager.getValue(TASK0), manager.getValue(TASK1),
                manager.getValue(TASK2), manager.getValue(TASK3), manager.getValue(TASK4), manager.getValue(TASK5),
                manager.getValue(TASK6), manager.getValue(TASK7), manager.getValue(TASK8), manager.getValue(TASK9),
                manager.getValue(TASK10), manager.getValue(TASK11), manager.getValue(TASK12), manager.getValue(TASK13),
                manager.getValue(TASK14), manager.getValue(TASK15),manager.getValue(TASK16), manager.getValue(EXIT));
        System.out.println(options);
    }

    public int readIntParam() {
        return scanner.nextInt();
    }

    public String readStringParam() {
        return scanner.nextLine();
    }

    public void showParamsInputRequest(String requiredParams) {
        System.out.println(requiredParams);
    }
}
