package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    public void itemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Bug"),
                new Item("Aisik"),
                new Item("Funtic"),
                new Item("Dog"),
                new Item("Second"),
                new Item("First")
        );
        List<Item> expected = Arrays.asList(
                new Item("Aisik"),
                new Item("Bug"),
                new Item("Dog"),
                new Item("First"),
                new Item("Funtic"),
                new Item("Second")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}