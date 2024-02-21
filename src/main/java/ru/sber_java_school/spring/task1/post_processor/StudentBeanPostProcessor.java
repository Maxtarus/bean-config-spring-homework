package ru.sber_java_school.spring.task1.post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.sber_java_school.spring.task1.data.Student;

@Component
public class StudentBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Student) {
            Student student = (Student) bean;
            if ("Jil".equals(student.getName())) {
                student.getAcademicPerformance()
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue().getDigitMark() < 3)
                        .forEach(e -> student.getAcademicPerformance().put(
//                                e.getKey(), Mark.EXCELLENT));
                                e.getKey(), e.getValue().convertDigitMarkToString(
                                        e.getValue()
                                        .getDigitMark() + 1)));
            }
        }

        return bean;
    }


}
