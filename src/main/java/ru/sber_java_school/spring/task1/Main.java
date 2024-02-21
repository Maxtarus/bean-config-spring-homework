package ru.sber_java_school.spring.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sber_java_school.spring.task1.config.ConfigAppContext;
import ru.sber_java_school.spring.task1.data.Teacher;

public class Main {

    public static void main(String[] args) {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext javaContext = new AnnotationConfigApplicationContext(ConfigAppContext.class);

        Teacher xmlTeacher = xmlContext.getBean("teacher", Teacher.class);
        Teacher javaTeacher = javaContext.getBean("teacher", Teacher.class);

        System.out.println(xmlTeacher);
        System.out.println(javaTeacher);
    }
}