package by.epam.training.jwd.task04.client.dao;

import by.epam.training.jwd.task04.client.dao.exception.DAOException;

import java.io.File;

public interface BookDao {

    String getData(String fileName) throws DAOException;
}
