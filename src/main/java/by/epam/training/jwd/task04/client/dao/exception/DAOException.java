package by.epam.training.jwd.task04.client.dao.exception;

public class DAOException extends Exception{
    private static final long serialVersionUID = 1L;

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception cause){
        super(cause);
    }

    public DAOException(String message, Exception cause){
        super(message, cause);
    }
}
