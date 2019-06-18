package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsFrequencyImpl implements WordFrequency<Map<String, Integer>> {

    @Override
    public Map<String, Integer> countWords(@NonNull String pathToFile) throws FileNotFoundException {

        Map<String, Integer> freqMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new FileReader(pathToFile))) {

            while (scanner.hasNext()) {
                freqMap.merge(scanner.next().toLowerCase(), 1, Integer::sum);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return freqMap;
    }
}
