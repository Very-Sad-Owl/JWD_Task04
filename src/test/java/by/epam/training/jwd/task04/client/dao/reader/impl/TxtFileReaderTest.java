package by.epam.training.jwd.task04.client.dao.reader.impl;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TxtFileReaderTest {

    @Test
    public void read_() throws IOException {
        TxtFileReader reader = new TxtFileReader();
        String content = reader.read("book.txt");

        System.out.println(content);
    }
}