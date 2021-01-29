package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.bean.text_components.Component;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.Comparator;

import static by.epam.training.jwd.task04.server.service.operation.properties.OperationProperties.*;

public class AlphOrderByFirsConsontant implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        //String pattern = "\\b[^\\sAEIOUaeiou]*[aeiouAEIOU]+";
        String pattern =  ResourceManager.getInstance().getValue(PART_BEFORE_CONSONTANT);
        String part1 = o1.getContent().replaceAll(pattern, "");
        String part2 = o2.getContent().replaceAll(pattern, "");

        int res = String.CASE_INSENSITIVE_ORDER.compare(part1, part2);
        if (res == 0) {
            res = part1.compareTo(part2);
        }
        return res;
    }
}
