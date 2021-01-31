package by.epam.training.jwd.task04.client.controller.exception;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ControllerException(){}

    public ControllerException(String msg, Exception cause){
        super(msg, cause);
    }

    public ControllerException(String msg){
        super(msg);
    }

    public ControllerException(Exception cause){
        super(cause);
    }
}
