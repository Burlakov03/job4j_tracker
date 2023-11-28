package ru.job4j.search;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByNull() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Helf", "898980", "Egy")
        );
        phones.add(
                new Person("Trest", "Hermesd", "4444444", "Stamby")
        );
        phones.add(
                new Person("Delte", "Poker", "78451280", "Bishkek")
        );
        var persons = phones.find("null");
        assertThat(persons.isEmpty()).isTrue();
    }

    @Test
    public void whenFindByNumberTwo() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Helf", "898980", "Egy")
        );
        phones.add(
                new Person("Trest", "Hermesd", "4444444", "Stamby")
        );
        phones.add(
                new Person("Delte", "Poker", "78451280", "Bishkek")
        );
        var persons = phones.find("80");
        assertThat(persons.size()).isEqualTo(2);
    }
}
