package by.epam.training.jwd.task04.client.dao.reader.impl;

import by.epam.training.jwd.task04.client.dao.reader.BasicReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader implements BasicReader {

    public TxtFileReader() {
    }

    public String read(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        StringBuilder content = new StringBuilder();
        String line;

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        line = reader.readLine();

        while(line != null) {
            content.append("\n");
            content.append(line);
            line = reader.readLine();
        }

        reader.close();
        fileReader.close();

        return content.toString();
    }
}
