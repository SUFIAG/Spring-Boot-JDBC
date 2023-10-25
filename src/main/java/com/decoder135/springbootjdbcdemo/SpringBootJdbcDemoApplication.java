package com.decoder135.springbootjdbcdemo;

import com.decoder135.springbootjdbcdemo.dao.DAO;
import com.decoder135.springbootjdbcdemo.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJdbcDemoApplication {

    private static DAO<Course> dao;

    public SpringBootJdbcDemoApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcDemoApplication.class, args);

        System.out.println("\n Create Courses -------------------- \n");
        Course newCourse = new Course("Spring Boot + Vue", "New Course", "https://www.decoder135.com/courses");
        dao.create(newCourse);

        System.out.println("\n One Courses -------------------- \n");
        Optional<Course> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        newCourse.setDescription("Learn to build Vue apps that talk to Spring Boot");
        dao.update(newCourse, 6);

        dao.delete(4);

        System.out.println("\n All Courses -------------------- \n");
        List<Course> courses = dao.list();

        courses.forEach(System.out::println);
    }

}
