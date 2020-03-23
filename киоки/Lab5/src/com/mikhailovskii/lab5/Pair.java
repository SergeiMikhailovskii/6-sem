package com.mikhailovskii.lab5;

public class Pair<T, V> {

    private T firstKey;
    private V secondKey;

    Pair(T firstKey, V secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public T getFirstKey() {
        return firstKey;
    }

    public V getSecondKey() {
        return secondKey;
    }

    @Override
    public String toString() {
        return "{" + firstKey + ", " + secondKey + "}";
    }
}
