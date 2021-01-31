package by.epam.training.jwd.task04.server.network.exception;

public class ServerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServerException(){}

    public ServerException(String msg, Exception cause){
        super(msg, cause);
    }

    public ServerException(String msg){
        super(msg);
    }

    public ServerException(Exception cause){
        super(cause);
    }
}
