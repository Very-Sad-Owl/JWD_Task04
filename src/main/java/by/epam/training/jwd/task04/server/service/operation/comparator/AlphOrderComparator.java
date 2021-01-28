package by.epam.training.jwd.task04.server.service.operation.comparator;

import by.epam.training.jwd.task04.bean.Component;

import java.util.Comparator;

public class AlphOrderComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getContent(), o2.getContent());
        if (res == 0) {
            res = o1.getContent().compareTo(o2.getContent());
        }
        return res;
    }
}
