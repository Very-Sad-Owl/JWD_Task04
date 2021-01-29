package by.epam.training.jwd.task04.server.service.text_builder;

import by.epam.training.jwd.task04.bean.text_components.impl.composite.Text;

public interface TextBuilder {

    Text parseText(String source);
}
