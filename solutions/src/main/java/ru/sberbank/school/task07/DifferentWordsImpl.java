package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DifferentWordsImpl implements DifferentWords<Set<String>> {


    @Override
    public Set<String> findSortedDifferentWords(@NonNull String pathToFile) throws FileNotFoundException {

        Set<String> words = new TreeSet<>(Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo));

        try (Scanner scanner = new Scanner(new FileReader(pathToFile))) {

            while (scanner.hasNext()) {
                words.add(scanner.next().toLowerCase());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return words;
    }
}
