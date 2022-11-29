package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameTest {

    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("One bug", 1),
                new Job("Fix bug", 1),
                new Job("Big bug", 1)
        );
        List<Job> expected = Arrays.asList(
                new Job("Big bug", 1),
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("One bug", 1)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorAscByName2() {
        List<Job> jobs = Arrays.asList(
                new Job("One bug", 9),
                new Job("Impl task", 0),
                new Job("Big bug", 1),
                new Job("Fix bug", 10)
        );
        List<Job> expected = Arrays.asList(
                new Job("Big bug", 1),
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("One bug", 1)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }
}