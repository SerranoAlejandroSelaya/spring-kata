package com.ss.web.app.repository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class EnrollmentRepoImplTest {

    @Mock
    private EnrollmentRepoImpl enrollmentRepo;

    @InjectMocks
    private EnrollmentRepoImpl enrollmentRepoImpl;

    @Test
    public void testListStudentsByStudent_shouldReturnListStudents_whenStudentsInList() {
        Subject subject = new Subject(101L, "Math", "It's math");
        Student first = new Student(201L, "Next", "Test");
        Student third = new Student(203L, "Sho", "Test");
        List<Student> expectedStudents = new ArrayList<>();
        expectedStudents.add(first);
        expectedStudents.add(third);

        List<Student> actualStudents = enrollmentRepoImpl.listStudents(subject);
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testListSubjectsBySubject_shouldReturnListSubjects_whenSubjectsInList() {
        Student student = new Student(201L, "Next", "Test");
        Subject math = new Subject(101L, "Math", "It's math");
        Subject programming = new Subject(103L, "Programming", "It's programming");
        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(math);
        expectedSubjects.add(programming);

        List<Subject> actualSubjects = enrollmentRepoImpl.listSubjects(student);
        assertEquals(expectedSubjects, actualSubjects);
    }

    @Test
    public void testListStudentsById_shouldReturnListStudents_whenStudentsInList() {
        Long id = 101L;
        Subject math = new Subject(101L, "Math", "It's math");
        Student first = new Student(201L, "Next", "Test");
        Student third = new Student(203L, "Sho", "Test");
        List<Student> expectedStudents = new ArrayList<>();
        expectedStudents.add(first);
        expectedStudents.add(third);

        List<Student> actualStudents = enrollmentRepoImpl.listStudents(id);
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testListSubjectsById_shouldReturnListSubjects_whenSubjectsInList() {
        Long id = 201L;
        Subject math = new Subject(101L, "Math", "It's math");
        Subject programming = new Subject(103L, "Programming", "It's programming");

        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(math);
        expectedSubjects.add(programming);

        List<Subject> actualSubjects = enrollmentRepoImpl.listSubjects(id);
        assertEquals(actualSubjects,expectedSubjects);
    }
}
