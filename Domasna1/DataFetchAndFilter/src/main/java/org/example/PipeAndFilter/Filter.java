package org.example.PipeAndFilter;

public interface Filter<T> {
    T execute(T input);
}
