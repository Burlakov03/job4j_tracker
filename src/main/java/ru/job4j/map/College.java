package ru.job4j.map;

import java.util.Map;
import java.util.Set;

public class College {
    private final Map<Student, Set<SubjectOfStudy>> students;

    public College(Map<Student, Set<SubjectOfStudy>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        return students.keySet().stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    public SubjectOfStudy findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            return students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<SubjectOfStudy>> students =
                Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new SubjectOfStudy("Math", 70),
                        new SubjectOfStudy("English", 85)
                )
        );
        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        SubjectOfStudy english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}