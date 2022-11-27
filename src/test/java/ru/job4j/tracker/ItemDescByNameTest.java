package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    public void itemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Bug"),
                new Item("Aisik"),
                new Item("Funtic"),
                new Item("Dog"),
                new Item("Second"),
                new Item("First")
        );
        List<Item> expected = Arrays.asList(
                items.get(4),
                items.get(2),
                items.get(5),
                items.get(3),
                items.get(0),
                items.get(1)
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }

}