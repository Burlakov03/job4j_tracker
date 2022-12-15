package ru.job4j.map;

import java.util.Objects;

public class SubjectOfStudy {
    private String name;
    private int score;

    public SubjectOfStudy(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubjectOfStudy that = (SubjectOfStudy) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SubjectOfStudy{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
