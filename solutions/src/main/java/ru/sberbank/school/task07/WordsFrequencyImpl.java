package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsFrequencyImpl implements WordFrequency<Map<String, Integer>> {

    private FileParser parser;

    public WordsFrequencyImpl(@NonNull FileParser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String, Integer> countWords(@NonNull String pathToFile) throws FileNotFoundException {

        Map<String, Integer> freqMap = new HashMap<>();
        List<String> lines = parser.parse(pathToFile);

        for (String line : lines) {
            for (String word : line.split("\\s+")) {
                freqMap.merge(word, 1, Integer::sum);
            }
        }

        return freqMap;
    }
}
