package by.epam.training.jwd.task04.client.dao.exception;

public class DAOException extends Exception{

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(String message, Exception cause){
        super(message, cause);
    }
}
