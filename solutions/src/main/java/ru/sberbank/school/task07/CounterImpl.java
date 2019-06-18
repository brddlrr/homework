package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CounterImpl implements Counter {

    @Override
    public int count(@NonNull String pathToFile) throws FileNotFoundException {

        Set<String> words = new HashSet<>();

        try (Scanner scanner = new Scanner(new FileReader(pathToFile))) {

            while (scanner.hasNext()) {
                words.add(scanner.next().toLowerCase());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return words.size();
    }
}
