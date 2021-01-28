package by.epam.training.jwd.task04.client;

import by.epam.training.jwd.task04.client.controller.Controller;
import by.epam.training.jwd.task04.client.controller.exception.ControllerException;
import by.epam.training.jwd.task04.client.dao.DaoFactory;
import by.epam.training.jwd.task04.client.view.ViewFactory;
import by.epam.training.jwd.task04.client.resource_manager.ResourceManager;
import org.apache.log4j.Logger;

import static by.epam.training.jwd.task04.client.LauncherParameter.*;

public class Launcher {

    private static final Logger LOGGER = Logger.getLogger(Launcher.class);
    private static ResourceManager manager = ResourceManager.getInstance();

    public static void main(String[] args) {

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            ViewFactory viewFactory = ViewFactory.getInstance();
            Controller controller = new Controller(daoFactory.getTxtBookDao(), viewFactory.getConsoleView());
            controller.startServer(manager.getValue(CLIENT_HOST), Integer.parseInt(manager.getValue(SERVER_PORT)));
        } catch (ControllerException e) {
            LOGGER.error("Client exception occurred!", e);
        }


    }
}
