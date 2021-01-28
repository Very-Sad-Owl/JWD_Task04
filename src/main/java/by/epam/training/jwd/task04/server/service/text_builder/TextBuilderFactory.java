package by.epam.training.jwd.task04.server.service.text_builder;

import by.epam.training.jwd.task04.server.service.text_builder.impl.TextBuilderImpl;

public class TextBuilderFactory {

    private static TextBuilderFactory instance = new TextBuilderFactory();
    private TextBuilder textBuilder = new TextBuilderImpl();

    public TextBuilderFactory(){}

    public static TextBuilderFactory getInstance(){
        return instance;
    }

    public TextBuilder getBuilder() {
        return textBuilder;
    }
}
