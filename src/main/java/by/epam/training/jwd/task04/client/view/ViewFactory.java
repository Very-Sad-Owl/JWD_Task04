package by.epam.training.jwd.task04.client.view;

import by.epam.training.jwd.task04.client.view.impl.ConsoleView;

public class ViewFactory {

    private static ViewFactory instance = new ViewFactory();
    private View consoleView = new ConsoleView();

    private ViewFactory(){}

    public static ViewFactory getInstance(){
        return instance;
    }

    public View getConsoleView(){
        return consoleView;
    }
}
