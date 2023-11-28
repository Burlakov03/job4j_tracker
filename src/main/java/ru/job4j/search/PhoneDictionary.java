package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combinePhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> combineSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> combineName = (p) -> p.getName().contains(key);
        Predicate<Person> combineAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = combinePhone.or(combineAddress).or(combineName).or(combineSurname);
        ArrayList<Person> result = new ArrayList<>();
            for (var p : person) {
                if (combine.test(p)) {
                    result.add(p);
                }
            }
        return result;
    }
}
