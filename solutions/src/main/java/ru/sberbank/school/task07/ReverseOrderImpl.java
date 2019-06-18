package ru.sberbank.school.task07;

import lombok.NonNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseOrderImpl implements ReverseOrder<List<String>> {

    @Override
    public List<String> getReverseOrderedStrings(@NonNull String pathToFile) throws FileNotFoundException {

        List<String> properOrder = new FileParserImpl().parse(pathToFile);
        List<String> reverseOrder = new ArrayList<>(properOrder.size());

        Iterator<String> iterator = new ReverseOrderIteratorImpl<>(properOrder);

        while (iterator.hasNext()) {
            reverseOrder.add(iterator.next());
        }

        return reverseOrder;
    }
}
