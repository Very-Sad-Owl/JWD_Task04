package by.epam.training.jwd.task04.bean.impl.composite;

import by.epam.training.jwd.task04.bean.Component;
import by.epam.training.jwd.task04.bean.impl.Code;
import by.epam.training.jwd.task04.bean.impl.LineEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Component {

    private static final long serialVersionUID = 1L;
    private List<Component> components;

    public Text(){}

    public Text(List<Component> components) {
        this.components = components;
    }

    public Text(Text text) {
        List<Component> copy = new ArrayList<>(text.components);
        //Collections.copy(copy, text.components);
        this.components = copy;
    }

    public void add(Component component) {
        if (components == null){
            components = new ArrayList<>();
        }
        components.add(component);
    }

    public void addAll(List<Component> component) {
        if (components == null){
            components = new ArrayList<>();
        }
        components.addAll(component);
    }

    public void remove(Component component) {
        if (components == null){
            components = new ArrayList<>();
        }
        components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {

        this.components.clear();
        List<Integer> positions = new ArrayList<>();
        int counter = 0;
        for (Component el : components){
            if (el.getContent().equals(".") || el.getContent().equals("!") || el.getContent().equals("?")){
                positions.add(counter);
            }
            counter++;
        }
    }

    public List<Sentence> getSentences(){
        ArrayList<Sentence> sentences = new ArrayList<>();
        for (Component el : components) {
            if (el.getClass() == Sentence.class) {
                sentences.add((Sentence) el);
            }
        }
        return sentences;
    }

    public List<Component> getWords(){
        List<Component> words = new ArrayList<>();
        for (Component component : getSentences()) {
            words.addAll(((Sentence)component).getWords());
        }
        return words;
    }

    public void parseToHighLevelComponents(){
        List<Component> highLevelComp = new ArrayList<>();
        Sentence sentence = new Sentence();
        for (Component el : components){
            if (el.getClass() != Sentence.class &&
                    el.getClass() != Code.class &&
                    el.getContent().matches("[.!?]")){
                sentence.add(el);
                highLevelComp.add(sentence);
                sentence = new Sentence();
            } else {
                sentence.add(el);
            }
        }
        this.components = highLevelComp;
    }

    public List<Component> toLowLevelComponents(){
        List<Component> lowComponents = new ArrayList<>();
        for (Component hLvlEl : components){
            if (hLvlEl.getClass() == Sentence.class){
                lowComponents.addAll(((Sentence) hLvlEl).getComponents());
            } else {
                lowComponents.add(hLvlEl);
            }
        }
        return lowComponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text = (Text) o;
        return Objects.equals(getComponents(), text.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponents());
    }

    @Override
    public String toString() {
        return "Text{" +
                "components=" + components +
                '}';
    }

    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component el : components){
            if (el.getClass() == LineEnd.class) {
                stringBuilder.append(System.getProperty("line.separator"));
            } else {
                stringBuilder.append(el.getContent());
            }
        }
        return stringBuilder.toString();
    }
}
