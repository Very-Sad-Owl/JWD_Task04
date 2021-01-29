package by.epam.training.jwd.task04.bean.text_components.impl;

import by.epam.training.jwd.task04.bean.text_components.Component;

import java.util.Objects;

public class Digit implements Component {

    private static final long serialVersionUID = 1L;
    private String digit;

    public Digit(){}

    public Digit(String digit) {
        this.digit = digit;
    }

    public String getContent() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Digit)) return false;
        Digit digit1 = (Digit) o;
        return Objects.equals(digit, digit1.digit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }

    @Override
    public String toString() {
        return "Digit{" +
                "digit=" + digit +
                '}';
    }
}
