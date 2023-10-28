package edu.hw3.task5;

import java.util.ArrayList;
import java.util.List;

public class SortContacts {
    private SortContacts() {
    }

    public static List<Contact> sort(ArrayList<String> contactsStr, String order) {
        if (contactsStr == null || contactsStr.isEmpty()) {
            return new ArrayList<>();
        }
        boolean isDescending = order.equals("DESC");

        ArrayList<Contact> contacts = parseContacts(contactsStr);

        contacts.sort((contact1, contact2) -> {
            String comp1 = contact1.surname() != null ? contact1.surname() : contact1.name();
            String comp2 = contact2.surname() != null ? contact2.surname() : contact2.name();

            return isDescending ? -comp1.compareTo(comp2) : comp1.compareTo(comp2);
        });

        return contacts;
    }

    private static ArrayList<Contact> parseContacts(ArrayList<String> contactsStr) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (String contactStr : contactsStr) {
            String[] tmpFullName = contactStr.split(" ");
            if (tmpFullName.length == 1) {
                contacts.add(new Contact(tmpFullName[0]));
            } else {
                contacts.add(new Contact(tmpFullName[0], tmpFullName[1]));
            }
        }
        return contacts;
    }
}
