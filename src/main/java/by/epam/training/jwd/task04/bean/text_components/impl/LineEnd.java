package by.epam.training.jwd.task04.bean.text_components.impl;

import by.epam.training.jwd.task04.bean.text_components.Component;

import java.util.Objects;

public class LineEnd implements Component {
    private String content = "\n";

    public LineEnd(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineEnd)) return false;
        LineEnd lineEnd = (LineEnd) o;
        return Objects.equals(getContent(), lineEnd.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "LineEnd{" +
                "content='" + content + '\'' +
                '}';
    }
}
