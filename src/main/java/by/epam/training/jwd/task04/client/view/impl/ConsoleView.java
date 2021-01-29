package by.epam.training.jwd.task04.client.view.impl;

import by.epam.training.jwd.task04.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.client.view.View;

public class ConsoleView implements View {

    public ConsoleView(){
    }

    public void showResponse(Text response){
        System.out.println(response.getContent());
    }

}
