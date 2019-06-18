package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnyStringNumberImpl implements AnyStringNumber<List<String>> {

    private FileParser parser;

    public AnyStringNumberImpl(@NonNull FileParser parser) {
        this.parser = parser;
    }

    @Override
    public List<String> findStringsByNumbers(@NonNull String pathToFile, Integer... numbers) throws FileNotFoundException {

        List<String> lines = parser.parse(pathToFile);
        List<String> picked = new ArrayList<>(numbers.length);

        for (int number : numbers) {
            if (number >= 0 && number < lines.size()) {
                picked.add(lines.get(number));
            }
        }

        return picked;
    }
}
