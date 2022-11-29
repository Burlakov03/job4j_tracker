package ru.job4j.collection;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescPriorityAndByAscName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByNameLnAndAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("One", 9),
                new Job("Impe", 0),
                new Job("Ono", 1),
                new Job("Fig", 1),
                new Job("Ones", 10)
        );
        List<Job> expected = Arrays.asList(
                new Job("Impe", 0),
                new Job("Ones", 1),
                new Job("Fig", 1),
                new Job("One", 1),
                new Job("Ono", 1)
        );
        jobs.sort(new JobDescByNameLn().thenComparing(new JobAscByName()));
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorAscByNameDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Ono", 9),
                new Job("Impe", 0),
                new Job("Ono", 1),
                new Job("Fig", 1),
                new Job("Ones", 10)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fig", 1),
                new Job("Impe", 0),
                new Job("Ones", 10),
                new Job("Ono", 9),
                new Job("Ono", 1)
        );
        jobs.sort(new JobAscByName().thenComparing(new JobDescByPriority()));
        assertThat(jobs).isEqualTo(expected);
    }
}