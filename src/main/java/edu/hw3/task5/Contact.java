package edu.hw3.task5;

public record Contact(String name, String surname) {

    public Contact(String name) {
        this(name, null);
    }
}
