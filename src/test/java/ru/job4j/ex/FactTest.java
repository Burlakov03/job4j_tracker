package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    public void whenException() {
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Fact().calc(-1));
    assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void when5FactorialThen120() {
        int n = 5;
        int results = new Fact().calc(n);
        int exception = 120;
        assertThat(exception).isEqualTo(results);
        }
}