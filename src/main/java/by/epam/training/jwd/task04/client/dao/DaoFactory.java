package by.epam.training.jwd.task04.client.dao;


import by.epam.training.jwd.task04.client.dao.impl.TxtBookDaoImpl;

public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final BookDao txtBookDao = new TxtBookDaoImpl();

    private DaoFactory(){}

    public BookDao getTxtBookDao(){
        return txtBookDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
