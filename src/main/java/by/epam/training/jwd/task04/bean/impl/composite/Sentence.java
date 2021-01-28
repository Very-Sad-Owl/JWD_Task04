package by.epam.training.jwd.task04.bean.impl.composite;

import by.epam.training.jwd.task04.bean.Component;
import by.epam.training.jwd.task04.bean.impl.LineEnd;
import by.epam.training.jwd.task04.bean.impl.PunctuationMark;
import by.epam.training.jwd.task04.bean.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence implements Component {

    private static final long serialVersionUID = 1L;
    private List<Component> components;

    public Sentence(){}

    public Sentence(List<Component> components) {
        this.components = components;
    }

    public void add(Component component) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.add(component);
    }

    public void remove(Component component) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.remove(component);
    }

    public boolean isQuestion(){
        return (components.get(components.size() -1 )).getContent().equals("?");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(getComponents(), sentence.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponents());
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "components=" + components +
                '}';
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Component> getWords(){
        List<Component> words = new ArrayList<>();
        for (Component component : components) {
            if (component.getClass() == Word.class) {
                words.add(component);
            }
        }
        return words;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }


    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < components.size()-1; i++){
            if (components.get(i).getClass() == LineEnd.class){
                builder.append(System.getProperty("line.separator"));
            } else {
                builder.append(components.get(i).getContent());
                if (components.get(i + 1).getClass() != PunctuationMark.class) {
                    builder.append(" ");
                }
            }
        }
        builder.append(components.get(components.size()-1).getContent()).append(" ");
        return builder.toString();
    }
}
