package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CounterImpl implements Counter {

    private FileParser parser;

    public CounterImpl(@NonNull FileParser parser) {
        this.parser = parser;
    }

    @Override
    public int count(@NonNull String pathToFile) throws FileNotFoundException {

        Set<String> words = new HashSet<>();
        List<String> lines =  parser.parse(pathToFile);

        for (String line : lines) {
            for (String word : line.split("\\s+")) {
                words.add(word);
            }
        }

        return words.size();
    }
}
