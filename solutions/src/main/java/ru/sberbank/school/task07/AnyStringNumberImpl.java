package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnyStringNumberImpl implements AnyStringNumber<List<String>> {

    @Override
    public List<String> findStringsByNumbers(@NonNull String pathToFile, Integer... numbers) throws FileNotFoundException {

        List<String> lines = new FileParserImpl().parse(pathToFile);
        List<String> picked = new ArrayList<>(numbers.length);

        for (int number : numbers) {

            if (number >= 0 && number < lines.size()) {

                picked.add(lines.get(number));
            }
        }

        return picked;
    }
}
