package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.bean.text_components.Component;
import by.epam.training.jwd.task04.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.operation.properties.OperationProperties.*;

public class OccuranceInTextComparator implements Comparator<Component> {
    private Text text;

    public OccuranceInTextComparator(){}

    public OccuranceInTextComparator(Text text){
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @Override
    public int compare(Component o1, Component o2) {
        int count1 = 0;
        int count2 = 0;

        Pattern word1 = Pattern.compile(String.format(ResourceManager.getInstance().getValue(STRING_OCCURANCE_REGEX), o1.getContent()));
        Pattern word2 = Pattern.compile(String.format(ResourceManager.getInstance().getValue(STRING_OCCURANCE_REGEX), o2.getContent()));
        Text trimmed = new Text(text.getWords());

        Matcher m1 = word1.matcher(trimmed.getContent());
        Matcher m2 = word2.matcher(trimmed.getContent());

        while (m1.find()) {
            count1++;
        }

        while (m2.find()) {
            count2++;
        }

        return count2 - count1;
    }
}
