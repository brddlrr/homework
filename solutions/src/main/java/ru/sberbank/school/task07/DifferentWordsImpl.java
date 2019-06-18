package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DifferentWordsImpl implements DifferentWords<Set<String>> {

    private FileParser parser;

    public DifferentWordsImpl(@NonNull FileParser parser) {
        this.parser = parser;
    }

    @Override
    public Set<String> findSortedDifferentWords(@NonNull String pathToFile) throws FileNotFoundException {

        Set<String> words = new TreeSet<>(Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo));
        List<String> lines = parser.parse(pathToFile);

        for (String line : lines) {
            for (String word : line.split("\\s+")) {
                words.add(word);
            }
        }

        return words;
    }
}
