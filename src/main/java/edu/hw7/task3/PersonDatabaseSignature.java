package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDatabaseSignature implements PersonDatabase {
    private final Map<Integer, Person> mapId = new HashMap<>();
    private final Map<String, List<Person>> mapName = new HashMap<>();
    private final Map<String, List<Person>> mapAddress = new HashMap<>();
    private final Map<String, List<Person>> mapPhone = new HashMap<>();

    @Override
    public void add(Person person) {
        if (mapId.containsKey(person.id())) {
            return;
        }
        mapId.put(person.id(), person);
        addMapName(person);
        addMapAddress(person);
        addMapPhone(person);
    }

    @Override
    public void delete(int id) {
        Person person = mapId.get(id);
        mapId.remove(id);
        deleteMapName(person);
        deleteMapAddress(person);
        deleteMapPhone(person);
    }

    @Override
    public List<Person> findByName(String name) {
        return mapName.get(name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return mapAddress.get(address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return mapPhone.get(phone);
    }

    private void addMapName(Person person) {
        List<Person> personList = new ArrayList<>();
        if (mapName.containsKey(person.name())) {
            personList = mapName.get(person.name());
        }
        personList.add(person);
        mapName.put(person.name(), personList);
    }

    private void addMapAddress(Person person) {
        List<Person> personList = new ArrayList<>();
        if (mapAddress.containsKey(person.address())) {
            personList = mapAddress.get(person.address());
        }
        personList.add(person);
        mapAddress.put(person.address(), personList);
    }

    private void addMapPhone(Person person) {
        List<Person> personList = new ArrayList<>();
        if (mapPhone.containsKey(person.phoneNumber())) {
            personList = mapPhone.get(person.phoneNumber());
        }
        personList.add(person);
        mapPhone.put(person.phoneNumber(), personList);
    }

    private void deleteMapName(Person person) {
        List<Person> personList = mapName.get(person.name());
        personList.remove(person);
        if (personList.isEmpty()) {
            mapName.remove(person.name());
            return;
        }
        mapName.put(person.name(), personList);
    }

    private void deleteMapAddress(Person person) {
        List<Person> personList = mapAddress.get(person.address());
        personList.remove(person);
        if (personList.isEmpty()) {
            mapAddress.remove(person.address());
            return;
        }
        mapAddress.put(person.address(), personList);
    }

    private void deleteMapPhone(Person person) {
        List<Person> personList = mapPhone.get(person.phoneNumber());
        personList.remove(person);
        if (personList.isEmpty()) {
            mapPhone.remove(person.phoneNumber());
            return;
        }
        mapPhone.put(person.phoneNumber(), personList);
    }
}
