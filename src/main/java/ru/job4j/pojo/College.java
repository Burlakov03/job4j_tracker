package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Гослинг Джеймс Иванович");
        student.setAdmission(LocalDate.now());
        student.setGroup("ИВТ-2022");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println("Студент, " + student.getName() + ", зачислен в группу " + student.getGroup() + " c " + student.getAdmission().format(formatter));
    }
}
