package ru.sber_java_school.spring.task1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sber_java_school.spring.task1.data.Mark;
import ru.sber_java_school.spring.task1.data.Student;
import ru.sber_java_school.spring.task1.data.Subject;
import ru.sber_java_school.spring.task1.post_processor.StudentBeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "ru.sber_java_school.spring.task1.data")
public class ConfigAppContext {
    @Bean
    public Student student1() {
        Map<Subject, Mark> academicPerformance = new HashMap<>();
        academicPerformance.put(Subject.MATHEMATICS, Mark.GOOD);
        academicPerformance.put(Subject.PHYSICS, Mark.GOOD);
        academicPerformance.put(Subject.INFORMATICS, Mark.EXCELLENT);
        return new Student("Maxim", academicPerformance);
    }

    @Bean
    public Student student2() {
        Map<Subject, Mark> academicPerformance = new HashMap<>();
        academicPerformance.put(Subject.MATHEMATICS, Mark.SATISFACTORY);
        academicPerformance.put(Subject.PHYSICS, Mark.UNSATISFACTORY);
        academicPerformance.put(Subject.INFORMATICS, Mark.SATISFACTORY);
        return new Student("Jil", academicPerformance);
    }

    @Bean
    public Student student3() {
        Map<Subject, Mark> academicPerformance = new HashMap<>();
        academicPerformance.put(Subject.MATHEMATICS, Mark.SATISFACTORY);
        academicPerformance.put(Subject.PHYSICS, Mark.SATISFACTORY);
        academicPerformance.put(Subject.INFORMATICS, Mark.GOOD);
        return new Student("Danila", academicPerformance);
    }

    @Bean
    public static StudentBeanPostProcessor beanPostProcessorBeanImpl() {
        return new StudentBeanPostProcessor();
    }
}
