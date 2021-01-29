package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.common.bean.text_components.Component;
import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Sentence;

import java.util.Comparator;

public class WordsCountComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        return ((Sentence)o1).getWords().size() - ((Sentence)o2).getWords().size();
    }
}
