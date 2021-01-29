package by.epam.training.jwd.task04.server.resource_manager.impl;

import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.ResourceBundle;

public class OperationResourceManager implements ResourceManager {

    private final static OperationResourceManager instance = new OperationResourceManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("operation");

    public static ResourceManager getInstance () {
        return instance;
    }
    @Override
    public String getValue(String key) {
        return bundle.getString(key);
    }
}
