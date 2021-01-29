package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.bean.text_components.Component;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.operation.properties.OperationProperties.*;

public class LetterPresenceComparator implements Comparator<Component> {
    private String letter;

    public LetterPresenceComparator(){}

    public LetterPresenceComparator(String letter){
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public int compare(Component o1, Component o2) {
        int count1 = 0;
        int count2 = 0;

        //String pattern = String.format("(?i)[%s]", letter);
        String pattern = String.format( ResourceManager.getInstance().getValue(CONTAINS_CHRSET), letter);
        Pattern r = Pattern.compile(pattern);

        Matcher m1 = r.matcher(o1.getContent());
        Matcher m2 = r.matcher(o2.getContent());

        while (m1.find()) {
            count1++;
        }

        while (m2.find()) {
            count2++;
        }

        if(count1 == count2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getContent(), o2.getContent());
            if (res == 0) {
                res = o1.getContent().compareTo(o2.getContent());
            }
            return res;
        }
        return count1 - count2;
    }
}
