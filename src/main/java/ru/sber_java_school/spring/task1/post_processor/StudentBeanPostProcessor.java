package ru.sber_java_school.spring.task1.post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.sber_java_school.spring.task1.data.Mark;
import ru.sber_java_school.spring.task1.data.Student;
import ru.sber_java_school.spring.task1.data.Subject;

import java.util.Map;

@Component
public class StudentBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            Student student = (Student) bean;
            if ("Jil".equals(student.getName())) {
                for (Map.Entry<Subject, Mark> e : student.getAcademicPerformance().entrySet()) {
                    int digitMark = e.getValue().getDigitMark();
                    if (digitMark >= 2 && digitMark <= 4) {
                        student.getAcademicPerformance()
                                .put(e.getKey(), e.getValue().convertDigitMarkToString(digitMark + 1));
                    }
                }
            }
        }

        return bean;
    }


}
