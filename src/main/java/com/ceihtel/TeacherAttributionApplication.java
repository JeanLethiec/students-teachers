package com.ceihtel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class TeacherAttributionApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TeacherAttributionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting simulation...");

        var teachers = List.of(
                new Teacher("Manuel", Specialty.Spanish, 0),
                new Teacher("Hervé", Specialty.Mathematics, 0),
                new Teacher("Simone", Specialty.Chemistry, 12),
                new Teacher("Roger", Specialty.Chemistry, 0),
                new Teacher("Jeanne", Specialty.Mathematics, 0)
        );

        var nbStudents = 324;

        TeacherAttributionLibraryKt.displayAssociation(
                TeacherAttributionLibraryKt.associateStudentsWithTeachers(nbStudents, teachers)
        );
    }
}
