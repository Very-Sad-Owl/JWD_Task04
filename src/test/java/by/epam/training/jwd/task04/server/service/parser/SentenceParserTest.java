package by.epam.training.jwd.task04.server.service.parser;

import by.epam.training.jwd.task04.common.bean.text_components.Component;
import by.epam.training.jwd.task04.server.service.text_builder.parser.SentenceParser;
import org.junit.Test;

import java.util.List;

public class SentenceParserTest {

    @Test
    public void parse_sentenceString_sentenceObject() {
        SentenceParser parser = new SentenceParser();
        String text = "Hello, world! This is a sentence i suppose.\nHey.";
        List<Component> sentence;

        sentence = parser.parse(text);

        System.out.println(sentence);

    }
}