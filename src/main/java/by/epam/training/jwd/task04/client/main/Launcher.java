package by.epam.training.jwd.task04.client.main;

import by.epam.training.jwd.task04.common.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.client.controller.Controller;
import by.epam.training.jwd.task04.client.controller.exception.ControllerException;
import by.epam.training.jwd.task04.client.controller.request_builder.RequestBuilder;
import by.epam.training.jwd.task04.client.controller.request_builder.impl.RequestBuilderImpl;
import by.epam.training.jwd.task04.client.dao.DaoFactory;
import by.epam.training.jwd.task04.client.dao.exception.DAOException;
import by.epam.training.jwd.task04.client.view.ViewFactory;
import by.epam.training.jwd.task04.client.main.resource_manager.ResourceManager;
import org.apache.log4j.Logger;

import java.io.IOException;

import static by.epam.training.jwd.task04.client.main.properties.LauncherParameter.*;

public class Launcher {

    private static final Logger LOGGER = Logger.getLogger(Launcher.class);
    private static ResourceManager manager = ResourceManager.getInstance();

    public static void main(String[] args) {

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            ViewFactory viewFactory = ViewFactory.getInstance();
            RequestBuilder builder = new RequestBuilderImpl();

            Controller controller = new Controller(daoFactory.getTxtBookDao(), viewFactory.getConsoleView());
            controller.startServer(manager.getValue(CLIENT_HOST), Integer.parseInt(manager.getValue(SERVER_PORT)));

            controller.uploadText(manager.getValue(FILE_PATH));

            controller.sendRequest(builder.requestForTask4(2));
            Text received = controller.getResponse();
            controller.showResponse(received);

            controller.stopServer();
        } catch (ControllerException | DAOException | IOException | ClassNotFoundException e) {
            LOGGER.error("Client exception occurred!", e);
        }


    }
}
