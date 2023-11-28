package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {
    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("One bug", 1),
                new Job("Fix bug", 1),
                new Job("Big bug", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("One bug", 1),
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Big bug", 1)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorDescByName2() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("One bug", 9),
                new Job("Fix bug", 10),
                new Job("Big bug", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("One bug", 1),
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Big bug", 1)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }
}