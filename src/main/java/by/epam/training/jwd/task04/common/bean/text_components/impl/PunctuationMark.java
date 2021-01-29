package by.epam.training.jwd.task04.common.bean.text_components.impl;

import by.epam.training.jwd.task04.common.bean.text_components.Component;

import java.util.Objects;

public class PunctuationMark implements Component {

    private static final long serialVersionUID = 1L;
    String mark;

    public PunctuationMark(){}

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    public String getContent() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunctuationMark)) return false;
        PunctuationMark that = (PunctuationMark) o;
        return Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                "mark='" + mark + '\'' +
                '}';
    }
}
