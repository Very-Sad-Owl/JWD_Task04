package by.epam.training.jwd.task04.client.controller;

import by.epam.training.jwd.task04.bean.network.ClientRequest;
import by.epam.training.jwd.task04.bean.text_components.impl.composite.Text;
import by.epam.training.jwd.task04.client.dao.BookDao;
import by.epam.training.jwd.task04.client.controller.exception.ControllerException;
import by.epam.training.jwd.task04.client.dao.exception.DAOException;
import by.epam.training.jwd.task04.client.view.View;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class Controller {

    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private BookDao dao;
    private View view;
    private static final Logger logger = Logger.getLogger(Controller.class);

    public Controller(){
    }

    public Controller(BookDao dao, View view){
        this.dao = dao;
        this.view = view;
    }

    public void startServer(final String host, final int port) throws ControllerException {
       // try {
            try {
                clientSocket = new Socket(host, port);
                logger.info("Client started\n");

                in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            throw  new ControllerException("Controller exception was occurred.", e);
        }
    }

    public void uploadText(String fileName) throws IOException, DAOException {
        out.writeObject(dao.getData(fileName));
    }


    public void sendRequest(ClientRequest req) throws IOException {
        out.writeObject(req);
    }

    public Text getResponse() throws IOException, ClassNotFoundException {
        return (Text)in.readObject();
    }

    public void showResponse(Text responce){
        view.showResponse(responce);
    }

    public void stopServer() {
        try {
            logger.info("Closing connection...\n");
            clientSocket.close();
            logger.info("Connection was closed.\n");
        } catch (IOException e) {
            logger.error("Connection has already been closed.\n");
        }
    }

}
