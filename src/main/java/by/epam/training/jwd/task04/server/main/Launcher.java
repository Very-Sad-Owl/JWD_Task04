package by.epam.training.jwd.task04.server.main;


import by.epam.training.jwd.task04.server.exception.ServerException;
import by.epam.training.jwd.task04.server.network.Server;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManagerBuilderFactory;
import org.apache.log4j.Logger;

import static by.epam.training.jwd.task04.server.main.LauncherProperties.*;

public class Launcher {

    private static final Logger LOGGER = Logger.getLogger(Launcher.class);
    private static final ResourceManager manager = ResourceManagerBuilderFactory.getInstance().getServerResource();

    public static void main( String[] args ) {
        try {
            Server server = new Server();
            server.startServer(Integer.parseInt(manager.getValue(SERVER_PORT)));
        } catch (ServerException e) {
            LOGGER.error("Server exception occurred!", e);
        }

    }
}
