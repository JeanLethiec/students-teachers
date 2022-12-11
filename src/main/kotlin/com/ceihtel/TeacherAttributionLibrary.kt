package com.ceihtel

import mu.KotlinLogging
import java.util.stream.Collectors.groupingBy

private val logger = KotlinLogging.logger {}

fun associateStudentsWithTeachers(nbStudents: Int, teachers: List<Teacher>): List<Teacher> {
    val teachersBySpecialty = teachers.stream().collect(groupingBy(Teacher::specialty));

    Specialty.values().forEach { specialty ->
        if (!teachersBySpecialty.containsKey(specialty)) {
            logger.warn { "No teacher for $specialty" }
        }
        val teachersForSpecialty = teachersBySpecialty[specialty]
        teachersForSpecialty?.forEach { teacher ->
            teacher.nbStudents = teacher.nbStudents + nbStudents / teachersForSpecialty.size;
        }
    }

    return teachers
}

fun displayAssociation(teachers: List<Teacher>) {
    teachers.forEach { teacher ->
        logger.info { "${teacher.name} teaches ${teacher.specialty} to ${teacher.nbStudents} students" }
    }
}

fun getIdealNumberOfStudentsPerTeacher(totalNumberOfStudents: Int, numberOfTeachers: Int): Int {
    return totalNumberOfStudents / numberOfTeachers;
}