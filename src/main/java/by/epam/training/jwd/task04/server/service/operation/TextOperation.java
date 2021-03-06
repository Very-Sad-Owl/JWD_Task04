package by.epam.training.jwd.task04.server.service.operation;

import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;

public interface TextOperation {

    Text sentencesWithSimilarWordsCount(Text text);
    Text sentenceByWordsCount(Text text);
    Text firstSentenceOriginalWord(Text text);
    Text equalLengthWordsInQSentences(Text text, int len);
    Text swapFirstAndLastWords(Text text);
    Text wordsByAlphOrder(Text text);
    Text wordsByVowelsProportion(Text text);
    Text wordsWithFirstVowelByFirsConsonantAlph(Text text);
    Text wordsByGivenLetterPresence(Text text, String letter);
    Text wordsByPresenceInText(Text text, String words);
    Text removeCertainSubstring(Text text, String ch1, String ch2);
    Text removeWordsWithFirstConsonant(Text text,int len);
    Text sortWordsBySymbolPresence(Text text, String symbol);
    Text findMaxPalindromSubstring(Text text);
    Text modifyWords(Text text);
    Text replaceWordsWithSubstring(Text text, int len, String substring, int pos);
}
