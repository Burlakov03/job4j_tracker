package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class JobAscByPriorityTest {

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> items = Arrays.asList(
                new Job("First", 13),
                new Job("Big", 1),
                new Job("Boy", 6),
                new Job("Small", 12),
                new Job("Girl", 3),
                new Job("world", 0)
        );
        List<Job> result = Arrays.asList(
                new Job("world", 0),
                new Job("Big",  1),
                new Job("Girl", 3),
                new Job("Boy", 6),
                new Job("Small", 12),
                new Job("First", 13)
        );
        items.sort(new JobAscByPriority());
        assertThat(items).isEqualTo(result);
    }

    @Test
    public void whenComparatorAscByPriority2() {
        List<Job> items = Arrays.asList(
                new Job("Big", 1),
                new Job("First", 13),
                new Job("Girl", 3),
                new Job("Boy", 6),
                new Job("world", 0),
                new Job("Small", 12)
        );
        List<Job> result = Arrays.asList(
                new Job("world", 0),
                new Job("Big",  1),
                new Job("Girl", 3),
                new Job("Boy", 6),
                new Job("Small", 12),
                new Job("First", 13)
        );
        items.sort(new JobAscByPriority());
        assertThat(items).isEqualTo(result);
    }
}