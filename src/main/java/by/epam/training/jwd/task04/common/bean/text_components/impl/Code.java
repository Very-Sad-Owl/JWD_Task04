package by.epam.training.jwd.task04.common.bean.text_components.impl;

import by.epam.training.jwd.task04.common.bean.text_components.Component;

import java.util.Objects;

public class Code implements Component {

    private static final long serialVersionUID = 1L;
    String code;

    public Code(){}

    public Code(String code) {
        this.code = code;
    }

    public String getContent() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }
}
