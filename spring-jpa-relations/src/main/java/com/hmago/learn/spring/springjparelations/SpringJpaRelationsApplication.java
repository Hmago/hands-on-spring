package com.hmago.learn.spring.springjparelations;

import com.hmago.learn.spring.springjparelations.entity.*;
import com.hmago.learn.spring.springjparelations.repo.CourseRepo;
import com.hmago.learn.spring.springjparelations.repo.CourseStudentMappingRepo;
import com.hmago.learn.spring.springjparelations.repo.StudentRepo;
import com.hmago.learn.spring.springjparelations.repo.UniversityRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class SpringJpaRelationsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaRelationsApplication.class, args);
    }

    private UniversityRepo universityRepo;

    private CourseRepo courseRepo;

    private StudentRepo studentRepo;

    private CourseStudentMappingRepo courseStudentMappingRepo;

    @Override
    public void run(String... args) throws Exception {

    	log.info("Adding data");
        // students
        Student s1 = Student.builder().name("student 1").build();
        Student s2 = Student.builder().name("student 2").build();
        Student s3 = Student.builder().name("student 3").build();
        Student s4 = Student.builder().name("student 4").build();
        studentRepo.save(s1);
        studentRepo.save(s2);
        studentRepo.save(s3);
        studentRepo.save(s4);

        // course
        Course c1 = Course.builder().name("Course 1").build();
        Course c2 = Course.builder().name("Course 2").build();
        Course c3 = Course.builder().name("Course 3").build();
        courseRepo.save(c1);
        courseRepo.save(c2);
        courseRepo.save(c3);

        // mappings
        CourseStudentMapping mapping1 = CourseStudentMapping.builder().course(c1).student(s1).build();
        CourseStudentMapping mapping2 = CourseStudentMapping.builder().course(c1).student(s2).build();

        CourseStudentMapping mapping3 = CourseStudentMapping.builder().course(c2).student(s2).build();
        CourseStudentMapping mapping4 = CourseStudentMapping.builder().course(c2).student(s3).build();
        CourseStudentMapping mapping5 = CourseStudentMapping.builder().course(c2).student(s4).build();

        courseStudentMappingRepo.save(mapping1);
        courseStudentMappingRepo.save(mapping2);
        courseStudentMappingRepo.save(mapping3);
        courseStudentMappingRepo.save(mapping4);
        courseStudentMappingRepo.save(mapping5);

        // college
		College col1 = College.builder().name("College 1").build();
		College col2 = College.builder().name("College 2").build();

        //University
		University uni1 = University.builder().name("University 1").college(col1).build();
		University uni2 = University.builder().name("University 2").college(col2).build();

        c1.setCollege(col1);
        c2.setCollege(col2);
        c3.setCollege(col2);

		col1.setUniversity(uni1);
		col2.setUniversity(uni2);

		// save
		universityRepo.save(uni1);
		universityRepo.save(uni2);

        courseRepo.save(c1);
        courseRepo.save(c2);
        courseRepo.save(c3);

		log.info("Done");

    }
}
