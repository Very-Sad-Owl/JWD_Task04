package by.epam.training.jwd.task04.server.resource_manager.impl;

import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.ResourceBundle;

public class ParserResourceManager implements ResourceManager {
    private final static ParserResourceManager instance = new ParserResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("parser");

    public static ResourceManager getInstance () {
        return instance;
    }

    @Override
    public String getValue(String key) {
        return bundle.getString(key);
    }
}
