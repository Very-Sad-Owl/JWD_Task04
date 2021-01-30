package by.epam.training.jwd.task04.server.service.parser;

import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.server.service.text_builder.parser.TextParser;
import org.junit.Test;

public class TextParserTest {

    @Test
    public void parse_someText_textObject() {
        String text = "We can have different type of houses, such as Wooden House and Glass\n" +
                "House.\n" +
                "public class WoodenHouse extends HouseTemplate {\n" +
                " @Override\n" +
                "public void buildWalls() {\n" +
                " System.out.println(\"Building Wooden Walls\");\n" +
                " }\n" +
                " @Override\n" +
                " public void buildPillars() {\n" +
                " System.out.println(\"Building Pillars with Wood coating\");\n" +
                " }\n" +
                "}\n" +
                "We could have overridden other methods also, but for simplicity I am not\n" +
                "doing that.";
        TextParser parser = new TextParser();

        Text expected = parser.parse(text);

        System.out.println(expected.getComponents());
    }

    @Test
    public void parse_simpleText_textObject() {
        String text = "way is a";
        TextParser parser = new TextParser();

        Text expected = parser.parse(text);

        System.out.println(expected.getComponents());
    }

    @Test
    public void parse_hugeText_textObj(){
        String text = "Mediator Pattern is one of the behavioral design pattern, so it deals with\n" +
                "the behaviors of objects. Mediator design pattern is used to provide a\n" +
                "centralized communication medium between different objects in a system.\n" +
                "Mediator design pattern is very helpful in an enterprise application where\n" +
                "multiple objects are interacting with each other. If the objects interact with\n" +
                "each other directly, the system components are tightly-coupled with each\n" +
                "other that makes maintainability cost higher and not flexible to extend\n" +
                "easily. Mediator pattern focuses on provide a mediator between objects for\n" +
                "communication and help in implementing lose-coupling between objects.\n" +
                "Air traffic controller is a great example of mediator pattern where the airport\n" +
                "control room works as a mediator for communication between different\n" +
                "flights. Mediator works as a router between objects and it can have it’s own\n" +
                "logic to provide way of communication.\n" +
                "The system objects that communicate each other are called Colleagues.\n" +
                "Usually we have an interface or abstract class that provides the contract for\n" +
                "communication and then we have concrete implementation of mediators.\n" +
                "For our example, we will try to implement a chat application where users\n" +
                "can do group chat. Every user will be identified by its name and they can\n" +
                "send and receive messages. The message sent by any user should be received\n" +
                "by all the other users in the group.\n" +
                "First of all we will create Mediator interface that will define the contract for\n" +
                "concrete mediators.\n" +
                "public interface ChatMediator {\n" +
                " public void sendMessage(String msg, User user);\n" +
                " void addUser(User user);\n" +
                "}\n" +
                "Users can send and receive messages, so we can have User interface or\n" +
                "abstract class. I am creating User as abstract class like below.\n" +
                "public abstract class User {\n" +
                " protected ChatMediator mediator;\n" +
                " protected String name;\n" +
                " public User(ChatMediator med, String name){\n" +
                " this.mediator=med;\n" +
                " this.name=name;\n" +
                " }\n" +
                " public abstract void send(String msg);\n" +
                " public abstract void receive(String msg);\n" +
                "}\n" +
                "Notice that User has a reference to the mediator object, it’s required for the\n" +
                "communication between different users.";

        TextParser parser = new TextParser();
        Text expected = parser.parse(text);

        System.out.println(expected.getContent());

    }
}