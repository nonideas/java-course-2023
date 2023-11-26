package edu.hw7.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDatabaseReadWriteLockTest {
    PersonDatabaseSignature pdb;

    @BeforeEach
    void initDB() {
        pdb = new PersonDatabaseReadWriteLock();
    }

    @Test
    void addOnePerson() {
        Person person = new Person(1, "Alex", "gg@alex.com", "5969944");
        pdb.add(person);
        Assertions.assertEquals(person, pdb.findByName("Alex").getFirst());
        Assertions.assertEquals(person, pdb.findByAddress("gg@alex.com").getFirst());
        Assertions.assertEquals(person, pdb.findByPhone("5969944").getFirst());
    }

    @Test
    void addTwoPerson() {
        Person person = new Person(1, "Alex", "gg@alex.com", "5969944");
        Person person2 = new Person(2, "Alex", "gg2@alex.com", "2222222");
        pdb.add(person);
        pdb.add(person2);
        Assertions.assertEquals(person, pdb.findByName("Alex").getFirst());
        Assertions.assertEquals(person2, pdb.findByName("Alex").getLast());
        Assertions.assertEquals(person, pdb.findByAddress("gg@alex.com").getFirst());
        Assertions.assertEquals(person, pdb.findByPhone("5969944").getFirst());
        Assertions.assertEquals(person2, pdb.findByPhone("2222222").getFirst());
    }

    @Test
    void deleteOnePerson() {
        Person person = new Person(1, "Alex", "gg@alex.com", "5969944");
        pdb.add(person);
        pdb.delete(1);
        Assertions.assertNull(pdb.findByName("Alex"));
        Assertions.assertNull(pdb.findByAddress("gg@alex.com"));
        Assertions.assertNull(pdb.findByPhone("5969944"));
    }

    @Test
    void deleteTwoPerson() {
        Person person = new Person(1, "Alex", "gg@alex.com", "5969944");
        Person person2 = new Person(2, "Alex", "gg2@alex.com", "2222222");
        pdb.add(person);
        pdb.add(person2);
        pdb.delete(1);
        Assertions.assertNull(pdb.findByAddress("gg@alex.com"));
        Assertions.assertNull(pdb.findByPhone("5969944"));
        Assertions.assertEquals(person2, pdb.findByName("Alex").getFirst());
        Assertions.assertEquals(person2, pdb.findByAddress("gg2@alex.com").getFirst());
        Assertions.assertEquals(person2, pdb.findByPhone("2222222").getFirst());
    }
}
