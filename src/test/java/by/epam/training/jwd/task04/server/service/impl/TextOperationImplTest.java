package by.epam.training.jwd.task04.server.service.impl;

import by.epam.training.jwd.task04.bean.impl.composite.Text;
import by.epam.training.jwd.task04.server.service.operation.impl.TextOperationImpl;
import by.epam.training.jwd.task04.server.service.text_builder.parser.TextParser;
import org.junit.Test;

public class TextOperationImplTest {

    private String text = "We can have different type of houses, such as Wooden House and Glass\n" +
            "House. Here is the code. Additional sentence! Hello olleh.\n" +
            "\n" +
            "public class WoodenHouse extends HouseTemplate {\n" +
            " @Override\n" +
            "public void buildWalls() {\n" +
            " System.out.println(\"Building Wooden Walls\");\n" +
            " }\n" +
            " @Override\n" +
            " public void buildPillars() {\n" +
            " System.out.println(\"Building Pillars with Wood coating\");\n" +
            " }\n" +
            "}\n" +
            "We could have overridden other methods also, but for simplicity I am not\n" +
            "doing that.";

    @Test
    public void sentenceByWordsCount_someText_SortedText(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().sentenceByWordsCount(arg);
        System.out.println(actual.getSentences());
        System.out.println(actual.getContent());

    }

    @Test
    public void wordsByAlphOrder_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().wordsByAlphOrder(arg);
        System.out.println(actual);
    }

    @Test
    public void wordsByVowelsProportion_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().wordsByVowelsProportion(arg);
        System.out.println(actual);
    }

    @Test
    public void wordsWithFirstVowelByFirsConsonantAlph(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().wordsWithFirstVowelByFirsConsonantAlph(arg);
        System.out.println(actual);
    }

    @Test
    public void wordsByGivenLetterProportion_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().wordsByGivenLetterPresence(arg, "e");
        System.out.println(actual);
    }

    @Test
    public void wordsByPresenceInText_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().wordsByPresenceInText(arg, "House is We");
        System.out.println(actual);
    }

    @Test
    public void sortWordsBySymbolPresence_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().sortWordsBySymbolPresence(arg, "e");
        System.out.println(actual);
    }

    @Test
    public void firstSentenceOriginalWord_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().firstSentenceOriginalWord(arg);
        System.out.println(actual);
    }

    @Test
    public void removeWordsWithFirstConsonant_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().removeWordsWithFirstConsonant(arg, 3);
        System.out.println(actual);
    }

    @Test
    public void findMaxPalindromSubstring_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().findMaxPalindromSubstring(arg);
        System.out.println(actual);
    }

    @Test
    public void modifyWords_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().modifyWords(arg);
        System.out.println(actual);
    }

    @Test
    public void sentencesWithSimilarWordsCount_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().sentencesWithSimilarWordsCount(arg);
        System.out.println(actual);
    }

    @Test
    public void replaceWordsWithSubstring_(){
        TextParser parser = new TextParser();
        Text arg = parser.parse(text);

        Text actual = new TextOperationImpl().replaceWordsWithSubstring(arg, 2, "hey boooi");
        System.out.println(actual);
    }

}