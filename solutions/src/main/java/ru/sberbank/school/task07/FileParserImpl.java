package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParser {

    @Override
    public List<String> parse(@NonNull String pathToFile) throws FileNotFoundException {

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))){

            while (br.ready()) {
                lines.add(br.readLine().toLowerCase());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return lines;
    }
}
