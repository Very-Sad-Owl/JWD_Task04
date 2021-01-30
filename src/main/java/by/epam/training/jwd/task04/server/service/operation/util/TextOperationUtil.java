package by.epam.training.jwd.task04.server.service.operation.util;

import by.epam.training.jwd.task04.common.bean.text_components.Component;
import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Sentence;
import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;

import java.util.List;
import java.util.stream.Collectors;

public class TextOperationUtil {

    public static void reduceRepetitions(List<Component> components){
        components = components.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    public static int getTrueSentencePosition(int pos, Text text){
        for (int i = 0; i< pos; i++){
            if (text.getComponents().get(i).getClass() != Sentence.class){
                pos++;
            }
        }
        return pos;
    }
}
