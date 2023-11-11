package org.example.PipeAndFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pipe<T> {
    private List<Filter<T>> filters = new ArrayList<Filter<T>>();

    public void addFilter(Filter<T> filter){
        filters.add(filter);
    }

    public List<T> runFilters(List<T> input){
        for (Filter<T> filter: filters) {
            input = input.stream().map(filter::execute).collect(Collectors.toList());
        }

        return input;
    }
}
