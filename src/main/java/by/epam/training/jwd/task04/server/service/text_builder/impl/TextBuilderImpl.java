package by.epam.training.jwd.task04.server.service.text_builder.impl;

import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.server.service.text_builder.TextBuilder;
import by.epam.training.jwd.task04.server.service.text_builder.parser.ParserFactory;
import by.epam.training.jwd.task04.server.service.text_builder.parser.TextParser;

public class TextBuilderImpl implements TextBuilder {
    @Override
    public Text parseText(String source) {
        ParserFactory factory = ParserFactory.getInstance();
        TextParser parser = factory.getTextParser();

        Text parsedText = parser.parse(source);

        return parsedText;

    }
}
