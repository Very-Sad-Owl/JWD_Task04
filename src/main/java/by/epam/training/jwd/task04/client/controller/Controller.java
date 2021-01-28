package by.epam.training.jwd.task04.client.controller;

import by.epam.training.jwd.task04.bean.impl.composite.Text;
import by.epam.training.jwd.task04.client.resource_manager.ResourceManager;
import by.epam.training.jwd.task04.client.dao.BookDao;
import by.epam.training.jwd.task04.client.controller.exception.ControllerException;
import by.epam.training.jwd.task04.client.dao.exception.DAOException;
import by.epam.training.jwd.task04.client.view.View;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

import static by.epam.training.jwd.task04.client.controller.properties.ControllerParameter.*;

public class Controller {

    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private BookDao dao;
    private View view;
    private static ResourceManager manager = ResourceManager.getInstance();
    private static final Logger logger = Logger.getLogger(Controller.class);

    public Controller(){
    }

    public Controller(BookDao dao, View view){
        this.dao = dao;
        this.view = view;
    }

    public void startServer(final String host, final int port) throws ControllerException {
        try {
            try {
                clientSocket = new Socket(host, port);
                logger.info("Client started\n");

                in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());


                uploadText(manager.getValue(FILE_PATH));


                boolean inUse = true;

                while (inUse){
                    showAvailableTasksList();
                    int taskNum = view.readIntParam();

                    switch (taskNum){
                        case 99:
                            inUse = false;
                            break;
                        case 0:
                            sendRequest(taskNum);
                            break;
                        case 1:
                            sendRequest(taskNum);
                            break;
                        case 2:
                            sendRequest(taskNum);
                            break;
                        case 3:
                            sendRequest(taskNum);
                            break;
                        case 4:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_LEN));
                            int len4 = view.readIntParam();
                            sendRequest(len4);
                            break;
                        case 5:
                            sendRequest(taskNum);
                            break;
                        case 6:
                            sendRequest(taskNum);
                            break;
                        case 7:
                            sendRequest(taskNum);
                            break;
                        case 8:
                            sendRequest(taskNum);
                            break;
                        case 9:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_LETTER));
                            String letter9 = view.readStringParam();
                            sendRequest(letter9);
                            break;
                        case 10:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_WORDS));
                            String words10 = view.readStringParam();
                            sendRequest(words10);
                            break;
                        case 11:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_SUBSTR));
                            String substring11 = view.readStringParam();
                            sendRequest(substring11);
                            break;
                        case 12:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_LEN));
                            int len12 = view.readIntParam();
                            sendRequest(len12);
                            break;
                        case 13:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_LETTER));
                            String symbol13 = view.readStringParam();
                            sendRequest(symbol13);
                            break;
                        case 14:
                            sendRequest(taskNum);
                            break;
                        case 15:
                            sendRequest(taskNum);
                            break;
                        case 16:
                            sendRequest(taskNum);
                            view.showParamsInputRequest(manager.getValue(PARAM_LEN));
                            int len16 = view.readIntParam();
                            sendRequest(len16);
                            view.showParamsInputRequest(manager.getValue(PARAM_SUBSTR));
                            String substring16 = view.readStringParam();
                            sendRequest(substring16);
                            break;
                    }
                    Text received = getResponse();
                    view.showResponse(received);
                }

            } finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }
        } catch (IOException | ClassNotFoundException | DAOException e) {
            throw  new ControllerException("Controller exception was occurred.", e);
        }
    }

    public void uploadText(String fileName) throws IOException, DAOException {
        out.writeObject(dao.getData(fileName));
    }

    public void showAvailableTasksList(){
        view.showTaskOptions();
    }

    public void sendRequest(Object req) throws IOException {
        out.writeObject(req);
    }

    public Text getResponse() throws IOException, ClassNotFoundException {
        return (Text)in.readObject();
    }



}
