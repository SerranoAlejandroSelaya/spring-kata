package com.ss.web.app.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.EnrollmentRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class EnrollmentServiceImplTest {

    @Mock
    private EnrollmentRepo collegeRepo;

    @InjectMocks
    private EnrollmentServiceImpl enrollmentServiceImpl;

    @Test
    public void testFindAllStudents_shouldReturnListStudents_whenStudentsInList() {
        Long collegeId = 1L;
        List<Student> expectedStudents = createStudentList();
        when(collegeRepo.listStudents(collegeId)).thenReturn(expectedStudents);

        List<Student> actualStudents = enrollmentServiceImpl.findAllStudents(collegeId);
        assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testFindAllSubjects_shouldReturnListSubjects_whenSubjectsInList() {
        Long collegeId = 1L;
        List<Subject> expectedSubjects = createSubjectList();
        when(collegeRepo.listSubjects(collegeId)).thenReturn(expectedSubjects);

        List<Subject> actualSubjects = enrollmentServiceImpl.findAllSubjects(collegeId);
        assertEquals(expectedSubjects, actualSubjects);
    }

    private List<Student> createStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Ana", "Perez"));
        students.add(new Student(2L, "Juan", "Gomez"));
        return students;
    }

    private List<Subject> createSubjectList() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(101L, "Math", "s"));
        subjects.add(new Subject(102L, "History", "s"));
        return subjects;
    }
}
