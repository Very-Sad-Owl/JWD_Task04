package by.epam.training.jwd.task04.server.service.operation.impl;

import by.epam.training.jwd.task04.common.bean.text_components.Component;
import by.epam.training.jwd.task04.common.bean.text_components.impl.Code;
import by.epam.training.jwd.task04.common.bean.text_components.impl.Digit;
import by.epam.training.jwd.task04.common.bean.text_components.impl.LineEnd;
import by.epam.training.jwd.task04.common.bean.text_components.impl.Word;
import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Sentence;
import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManagerBuilderFactory;
import by.epam.training.jwd.task04.server.service.operation.TextOperation;
import by.epam.training.jwd.task04.server.service.operation.comparator.*;
import by.epam.training.jwd.task04.server.service.text_builder.parser.ParserFactory;
import by.epam.training.jwd.task04.server.service.text_builder.parser.SentenceParser;
import by.epam.training.jwd.task04.server.service.text_builder.parser.TextParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.operation.properties.OperationProperties.*;
import static by.epam.training.jwd.task04.server.service.operation.util.TextOperationUtil.*;

public class TextOperationImpl implements TextOperation {

    private static ParserFactory factory = ParserFactory.getInstance();
    private static final ResourceManager manager = ResourceManagerBuilderFactory.getInstance().getOperationResource();

    @Override
    public Text sentencesWithSimilarWordsCount(Text text) {
        Text res = new Text();
        int counter;
        int max = 0;
        for (Component el : text.getSentences()) {
            for (Component word : ((Sentence) el).getWords()) {
                counter = 0;
                String regex = String.format(manager.getValue(STRING_OCCURANCE_REGEX), word.getContent());
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(el.getContent());
                while (matcher.find() && counter <=2) {
                    counter++;
                }
                if (counter > 1) {
                    max++;
                    break;
                }
            }
        }
        res.add(new Digit(Integer.toString(max)));
        return res;
    }

    @Override
    public Text sentenceByWordsCount(Text text) {
        Text sorted = new Text(new ArrayList<>(text.getSentences()));
        Collections.sort(sorted.getComponents(), new WordsCountComparator());
        return sorted;
    }

    @Override
    public Text firstSentenceOriginalWord(Text text) {
        String regex = manager.getValue(STRING_OCCURANCE_REGEX);
        for (Component el : text.getSentences().get(0).getWords()) {
            int count = 0;
            Pattern pattern = Pattern.compile(String.format(regex, el.getContent()));
            Matcher matcher = pattern.matcher(text.getContent());
            while (matcher.find()){
                count++;
            }
            if (count < 2) {
                Text res = new Text();
                res.add(el);
                return res;
            }
        }
        return new Text();
    }

    @Override
    public Text equalLengthWordsInQSentences(Text text, int len) {
        List<Component> equalLenWords = new ArrayList<>();
        StringBuilder buff = new StringBuilder();
        for (Component el : text.getSentences()){
            if (((Sentence)el).isQuestion()) {
                for (Component component : ((Sentence) el).getComponents()) {
                    if (component.getClass() == Word.class && component.getContent().length() == len &&
                            !buff.toString().contains(component.getContent() + " ")) {
                        equalLenWords.add(component);
                        buff.append(component.getContent()).append(" ");
                    }
                }
            }
        }
        return new Text(equalLenWords);
    }

    @Override
    public Text swapFirstAndLastWords(Text text) {
        List<Sentence> sentences = text.getSentences();
        List<Component> swapped = new ArrayList<>();
        Collections.copy(swapped, sentences);
        Collections.swap(swapped, 0, swapped.size() - 1);
        return new Text(swapped);
    }

    @Override
    public Text wordsByAlphOrder(Text text) {
        List<Component> sorted = new ArrayList<>();
        List<Component> words = text.getWords();
        Collections.sort(words, new AlphOrderComparator());

        reduceRepetitions(words);

        String tempChar = words.get(0).getContent().charAt(0) + "";
        String currentChar;
        sorted.add(words.get(0));
        for (int i = 1; i < words.size(); i++){
            currentChar = words.get(i).getContent().charAt(0) + "";
            if (tempChar.equalsIgnoreCase(currentChar)){
                sorted.add(words.get(i));
            } else {
                sorted.add(new LineEnd());
                sorted.add(words.get(i));
                tempChar = words.get(i).getContent().charAt(0) + "";
            }
        }
        return new Text(sorted);
    }

    @Override
    public Text wordsByVowelsProportion(Text text) {
        List<Component> words = text.getWords();
        Collections.sort(words, new VowelsProportionComparator());

         reduceRepetitions(words);

        return new Text(new ArrayList<>(words));
    }

    @Override
    public Text wordsWithFirstVowelByFirsConsonantAlph(Text text) {
        List<Component> firstVowelWords = new ArrayList<>();
        for (Component el : text.getWords()) {
            if (el.getContent().matches(manager.getValue(FIRST_VOWEL_REGEX))) {
                firstVowelWords.add(el);
            }
        }

        reduceRepetitions(firstVowelWords);

        Text sorted = new Text(firstVowelWords);
        Collections.sort(sorted.getComponents(), new AlphOrderByFirsConsontant());
        return sorted;
    }

    @Override
    public Text wordsByGivenLetterPresence(Text text, String letter) {
        List<Component> words = text.getWords();

        Collections.sort(words, new LetterPresenceComparator(letter));

        reduceRepetitions(words);

        return new Text(new ArrayList<>(words));
    }

    @Override
    public Text wordsByPresenceInText(Text text, String words) {
        TextParser parser = factory.getTextParser();
        Text content = parser.parse(words);
        List<Component> wordList = content.toLowLevelComponents();
        Collections.sort(wordList, new OccuranceInTextComparator(text));
        return new Text(wordList);
    }

    @Override
    public Text removeCertainSubstring(Text text, String ch1, String ch2) {
        TextParser parser = factory.getTextParser();
        String textStr = text.getContent();
        textStr = textStr.replaceAll(String.format(manager.getValue(FROM_CHAR_TO_CHAR_SUBSTR), ch1, ch2), "");

        return parser.parse(textStr);
    }

    @Override
    public Text removeWordsWithFirstConsonant(Text text, int len) {
        List<Component> appropriateelements = new ArrayList<>();
        Sentence sentence;
        for (Component majorEl : text.getComponents()){
            if (majorEl.getClass() == Code.class || majorEl.getClass() == LineEnd.class){
                appropriateelements.add(majorEl);
            } else {
                sentence = new Sentence();
                for (Component el : ((Sentence)majorEl).getComponents()){
                    if (el.getClass() != Word.class){
                        sentence.add(el);
                    } else {
                        if (el.getContent().length() != len ||
                                ((Character) el.getContent().charAt(0)).toString().matches(manager.getValue(FIRST_VOWEL_REGEX))) {
                            sentence.add(el);
                        }
                    }
                }
                appropriateelements.add(sentence);
            }

        }
        return new Text(appropriateelements);
    }

    @Override
    public Text sortWordsBySymbolPresence(Text text, String symbol) {
        List<Component> words = text.getWords();
        Collections.sort(words, new LetterPresenceComparator(symbol));

        reduceRepetitions(words);

        return new Text(new ArrayList<>(words));
    }

    @Override
    public Text findMaxPalindromSubstring(Text text) {
        SentenceParser parser = factory.getSentenceParser();
        String substring = "";
        int maxLen = 0;
        String regex = manager.getValue(PALINDROM_REGEX);
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text.getContent());
        while (matcher.find()){
            String palindriom = matcher.group();
            if (maxLen < palindriom.length()) {
                substring = palindriom;
                maxLen = palindriom.length();
            }
        }
        return new Text(parser.parse(substring));
    }

    @Override
    public Text modifyWords(Text text) {
        ArrayList<Component> newContent = new ArrayList<>();
        for (Component el : text.toLowLevelComponents()) {
            if (el.getClass() == Word.class) {
                String modified = el.getContent().charAt(0) +
                        el.getContent().replaceAll(String.format(manager.getValue(CONTAINS_CHRSET), el.getContent().charAt(0)), "");
                newContent.add(new Word(modified));
            } else {
                newContent.add(el);
            }
        }
        return new Text(newContent);
    }

    @Override
    public Text replaceWordsWithSubstring(Text text, int len, String substring, int pos) {
        TextParser parser = factory.getTextParser();
        Text parsedSubstring = parser.parse(substring);
        Text modified = new Text(text.getComponents());
        int truePos = getTrueSentencePosition(pos, text);
        Sentence selected = (Sentence) modified.getComponents().get(truePos);

        ListIterator<Component> iterator = selected.getComponents().listIterator();
        while (iterator.hasNext()){
            Component el = iterator.next();
            if (el.getClass() == Word.class && el.getContent().length() == len){
                iterator.remove();
                for (Component word : parsedSubstring.getComponents()){
                    iterator.add(word);
                }
            }
        }
        return modified;
    }
}
