package by.epam.training.jwd.task04.server.resource_manager;

import by.epam.training.jwd.task04.server.resource_manager.impl.OperationResourceManager;
import by.epam.training.jwd.task04.server.resource_manager.impl.ParserResourceManager;
import by.epam.training.jwd.task04.server.resource_manager.impl.ServerResourceManager;

public class ResourceManagerBuilderFactory {

    private static final ResourceManagerBuilderFactory instance = new ResourceManagerBuilderFactory();
    private final ResourceManager operationResource = new OperationResourceManager();
    private final ResourceManager parserResource = new ParserResourceManager();
    private final ResourceManager serverResource = new ServerResourceManager();

    private ResourceManagerBuilderFactory(){}

    public static ResourceManagerBuilderFactory getInstance(){
        return instance;
    }

    public ResourceManager getOperationResource(){
        return operationResource;
    }

    public ResourceManager getParserResource(){
        return parserResource;
    }

    public ResourceManager getServerResource(){
        return serverResource;
    }
}
