package by.epam.training.jwd.task04.server.service.text_builder.parser;

import by.epam.training.jwd.task04.bean.text_components.Component;
import by.epam.training.jwd.task04.bean.text_components.impl.Digit;
import by.epam.training.jwd.task04.bean.text_components.impl.LineEnd;
import by.epam.training.jwd.task04.bean.text_components.impl.PunctuationMark;
import by.epam.training.jwd.task04.bean.text_components.impl.Word;
import by.epam.training.jwd.task04.bean.text_components.impl.composite.Sentence;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.text_builder.properties.TextParserProperties.*;

public class SentenceParser {

    private static final ResourceManager manager = ResourceManager.getInstance();
    private static final Pattern sentencePattern = Pattern.compile
            (manager.getValue(SENTENCE_PARTS));
            //("(?<word>\\b[^\\s\\d]+\\b)((?<=\\.\\w).)?|(?<mark>[.,!?])|(?<digit>\\d)|(?<line>([\.\!\?][\n\r])");

    public List<Component> parse(String source) {
        String[] sentences = source.split("(?<=[\\.\\!\\?])\\s*");
        List<Component> parsed = new ArrayList<>();
        Matcher sentenceMatcher;

        for (String el : sentences) {

            sentenceMatcher = sentencePattern.matcher(el);
            Sentence sentence = new Sentence();

            while (sentenceMatcher.find()) {
                String lineBlock = sentenceMatcher.group(manager.getValue(LINE_BLOCK));
                String wordBlock = sentenceMatcher.group(manager.getValue(WORD_BLOCK));
                String markBlock = sentenceMatcher.group(manager.getValue(MARK_BLOCK));
                String digitBlock = sentenceMatcher.group(manager.getValue(DIGIT_BLOCK));

                if(lineBlock != null){
                    sentence.add(new LineEnd());
                }

                if (wordBlock != null) {
                    sentence.add(new Word(wordBlock));
                }

                if (markBlock != null) {
                    sentence.add(new PunctuationMark(markBlock));
                }

                if (digitBlock != null) {
                    sentence.add(new Digit(digitBlock));
                }

            }
            parsed.add(sentence);
        }

        return parsed;

    }
}
