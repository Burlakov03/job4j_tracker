package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<SubjectOfStudy>> students;

    public College(Map<Student, Set<SubjectOfStudy>> students) {
        this.students = students;
    }

    /**
     * Метод осуществляет поиск студента по аккаунту.
     *
     * @param account Аккаунт по которому осуществляется поиск студента.
     * @return Возвращает первого найденного студента в обертке Optional
     * или Optional.empty() в случае отсутствия студента.
     */
    public Optional<Student> findByAccount(String account) {
        return students.keySet().stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск дисциплины у указанного студента.
     *
     * @param name Наименование дисциплины для поиска
     * @return Метод возвращает:
     * 1) Optional.empty() если указанного студента нет в базе данных,
     * либо указанная дисциплина отсутствует у студента.
     * 2) Найденную дисциплину указанного студента в обертке Optional.
     */
    public Optional<SubjectOfStudy> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        return a.flatMap(student -> students.get(student)
                .stream()
                .filter(s -> s.getName().equals(name))
                .findFirst());
    }
}