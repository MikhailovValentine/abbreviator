package ru.urlshortening.abbreviator.service;

public interface InMemoryContainsURLChecker<T> {
    boolean noSuchURL(T url);
}
