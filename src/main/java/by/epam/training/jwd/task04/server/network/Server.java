package by.epam.training.jwd.task04.server.network;

import by.epam.training.jwd.task04.server.exception.ServerException;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManagerBuilderFactory;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static by.epam.training.jwd.task04.server.main.LauncherProperties.*;

public class Server {

    private static final ResourceManager manager = ResourceManagerBuilderFactory.getInstance().getServerResource();
    private static ExecutorService executeIt = Executors.newFixedThreadPool(Integer.parseInt(manager.getValue(MAX_USER)));
    private static final Logger LOGGER = Logger.getLogger(Server.class);

    public Server(){
    }

    public void startServer(int port) throws ServerException {

        Socket clientSocket;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            LOGGER.info("Server started!\n");
            while (!serverSocket.isClosed()) {
                clientSocket = serverSocket.accept();
                LOGGER.info("Accepting connection...\n");
                executeIt.execute(new ClientHandler(clientSocket));
                LOGGER.info("Connection accepted.\n");
            }
            executeIt.shutdown();
        } catch (IOException e) {
            throw new ServerException("Server exception occurred.\n", e);
        }
    }
}
