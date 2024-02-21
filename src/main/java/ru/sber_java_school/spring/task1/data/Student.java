package ru.sber_java_school.spring.task1.data;

import java.util.Map;

public class Student {
    private String name;
    private boolean isEnrolled = false;
    private Map<Subject, Mark> academicPerformance;

    public Student(String name, Map<Subject, Mark> academicPerformance) {
        this.name = name;
        this.academicPerformance = academicPerformance;
    }

    public String getName() {
        return name;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public Map<Subject, Mark> getAcademicPerformance() {
        return academicPerformance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", isEnrolled=" + isEnrolled +
                ", academicPerformance=" + academicPerformance +
                '}';
    }

    private double calculateAvgMark() {
        return academicPerformance.values()
                .stream()
                .mapToDouble(Mark::getDigitMark)
                .average()
                .orElse(0);
    }

    public void init() {
        isEnrolled = calculateAvgMark() >= 3.0;
    }


}
