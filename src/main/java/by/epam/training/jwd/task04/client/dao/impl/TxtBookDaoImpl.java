package by.epam.training.jwd.task04.client.dao.impl;

import by.epam.training.jwd.task04.client.dao.BookDao;
import by.epam.training.jwd.task04.client.dao.exception.DAOException;
import by.epam.training.jwd.task04.client.dao.reader.impl.TxtFileReader;

import java.io.*;

public class TxtBookDaoImpl implements BookDao {
    @Override
    public String getData(String fileName) throws DAOException {
        String content;
        try {
            TxtFileReader reader = new TxtFileReader();
            content = reader.read(fileName);
        } catch (IOException e){
            throw new DAOException("DAO exception was occurred.", e);
        }
        return content;
    }
}
