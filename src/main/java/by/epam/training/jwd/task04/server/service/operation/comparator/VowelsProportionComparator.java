package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.bean.text_components.Component;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.operation.properties.OperationProperties.CONTAINS_VOWEL_REGEX;

public class VowelsProportionComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        int count1 = 0;
        int count2 = 0;

        //String pattern = "(?i)[aeiouywAEIOUYW]";
        String pattern = ResourceManager.getInstance().getValue(CONTAINS_VOWEL_REGEX);
        Pattern r = Pattern.compile(pattern);

        Matcher m1 = r.matcher(o1.getContent());
        Matcher m2 = r.matcher(o2.getContent());

        while (m1.find()) {
            count1++;
        }

        while (m2.find()) {
            count2++;
        }
        return count2 * 100 / o2.getContent().length() - count1 * 100 / o1.getContent().length();
    }
}
