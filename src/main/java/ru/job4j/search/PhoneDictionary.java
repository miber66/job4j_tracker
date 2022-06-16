package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> prName = p -> p.getName().contains(key);
        Predicate<Person> prSurName = p -> p.getSurname().contains(key);
        Predicate<Person> prPhone = p -> p.getPhone().contains(key);
        Predicate<Person> prAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combine = prName.or(prSurName).or(prPhone).or(prAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
