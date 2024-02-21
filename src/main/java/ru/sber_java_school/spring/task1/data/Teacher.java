package ru.sber_java_school.spring.task1.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Teacher {
    @Value("Antipov Oleg Vladimirovich")
    private String name;

    private List<Student> students;

    public Teacher(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
