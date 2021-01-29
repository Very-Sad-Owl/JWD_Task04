package by.epam.training.jwd.task04.bean.text_components.impl;

import by.epam.training.jwd.task04.bean.text_components.Component;

import java.util.Objects;

public class Word implements Component {

    private static final long serialVersionUID = 1L;
    String word;

    public Word(){}

    public Word(String word){
        this.word = word;
    }

    public String getContent() {
        return word;
    }


    public void setContent(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
