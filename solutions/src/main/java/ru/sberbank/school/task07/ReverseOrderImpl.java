package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReverseOrderImpl implements ReverseOrder<List<String>> {

    @Override
    public List<String> getReverseOrderedStrings(@NonNull String pathToFile) throws FileNotFoundException {

        LinkedList<String> reverseOrder = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))){

            while (br.ready()) {
                reverseOrder.addFirst(br.readLine());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return reverseOrder;
    }
}
