package edu.hw3.task5;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortContactsTest {
    @Test
    void testASC() {
        ArrayList<String> input = new ArrayList<>();
        input.add("John Locke");
        input.add("Thomas Aquinas");
        input.add("David Hume");
        input.add("Rene Descartes");

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Thomas", "Aquinas"));
        contacts.add(new Contact("Rene", "Descartes"));
        contacts.add(new Contact("David", "Hume"));
        contacts.add(new Contact("John", "Locke"));

        List<Contact> sorted = SortContacts.sort(input, "ASC");
        assertEquals(contacts, sorted);
    }

    @Test
    void testDESC() {
        ArrayList<String> input = new ArrayList<>();
        input.add("Paul Erdos");
        input.add("Leonhard Euler");
        input.add("Carl Gauss");

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Carl", "Gauss"));
        contacts.add(new Contact("Leonhard", "Euler"));
        contacts.add(new Contact("Paul", "Erdos"));

        List<Contact> sorted = SortContacts.sort(input, "DESC");
        assertEquals(contacts, sorted);
    }

    @Test
    void testNames() {
        ArrayList<String> input = new ArrayList<>();
        input.add("A");
        input.add("B D");
        input.add("C");

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("A"));
        contacts.add(new Contact("C"));
        contacts.add(new Contact("B", "D"));

        List<Contact> sorted = SortContacts.sort(input, "ASC");
        assertEquals(contacts, sorted);
    }

    @Test
    void testNonStrings() {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Contact> contacts = new ArrayList<>();
        List<Contact> sorted = SortContacts.sort(input, "ASC");
        assertEquals(contacts, sorted);
    }

    @Test
    void testNullStrings() {
        ArrayList<String> input = null;
        ArrayList<Contact> contacts = new ArrayList<>();
        List<Contact> sorted = SortContacts.sort(input, "ASC");
        assertEquals(contacts, sorted);
    }
}
