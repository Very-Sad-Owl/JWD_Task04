package by.epam.training.jwd.task04.server.resource_manager.impl;

import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.ResourceBundle;

public class ServerResourceManager implements ResourceManager {

    private final static ServerResourceManager instance = new ServerResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("server");

    public static ResourceManager getInstance () {
        return instance;
    }

    @Override
    public String getValue(String key) {
        return bundle.getString(key);
    }
}
