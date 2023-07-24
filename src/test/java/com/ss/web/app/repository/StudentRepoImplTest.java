package com.ss.web.app.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.ss.web.app.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class StudentRepoImplTest {

    @Mock
    private StudentRepoImpl studentRepo;

    @InjectMocks
    private StudentRepoImpl studentRepoImpl;

    @ParameterizedTest
    @CsvSource({"100","500","1000","5000","10000"})
    public void givenStudentList_whenSaveMultipleStudents_thenAllStudentsAreSaved(int quantity) {
        List<Student> studentsAux = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Long idAux = (long) (i + 1);
            Student student = new Student(idAux, "ana", "perez");
            studentsAux.add(studentRepoImpl.save(student));
        }

        List<Student> actualStudents = studentRepoImpl.findAll();
        assertEquals(quantity+3, actualStudents.size());

    }

    @Test
    public void givenStudentList_whenFindAll_thenAllStudentsAreReturned() {
         List<Student> expectedStudents = createStudentList();

         List<Student> actualStudents = studentRepoImpl.findAll();
         assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void givenStudent_whenEdit_thenStudentIsUpdated() {
       Student student = new Student(1L, "Sho", "Test");

       Student editedStudent = studentRepoImpl.edit(student);
       assertEquals(student, editedStudent);
    }

    @Test
    public void givenStudent_whenDelete_thenStudentIsDeleted() {
        Student student = new Student(1L, "Sho", "Test");
        boolean isDeleted = studentRepoImpl.delete(student);
        assertTrue(isDeleted);
    }

    private List<Student> createStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Sho", "Test"));
        students.add(new Student(2L, "Auto", "Test"));
        students.add(new Student(3L, "Curl", "Test"));
        return students;
    }
}
