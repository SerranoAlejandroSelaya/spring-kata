package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  private StudentRepo repo;
  private StudentServiceImpl studentServiceImpl;

  @BeforeEach
  public void init(){
    repo = mock(StudentRepo.class);
    studentServiceImpl = new StudentServiceImpl(repo);
  }

  @Test
  public void addStudent() {
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @ParameterizedTest
  @CsvSource({"100","500","1000","5000","10000"})
  public void findAllTest_shouldReturnTotalNumberStudents_whenStudentsInList(int quantity) {
    List<Student> studentsAux = new ArrayList<>();

    for(int i = 0; i < quantity; i++){
      Long idAux = (long) quantity;
      Student student = new Student(idAux, "ana", "perez");
      when(repo.save(student)).thenReturn(student);
      studentsAux.add(studentServiceImpl.addStudent(student));
    }

    when(repo.findAll()).thenReturn(studentsAux);
    int numberStudents = studentServiceImpl.findAll().size();
    assertEquals(quantity, numberStudents);
  }

  @Test
  public void editTest_shouldReturnTheStudentEdit_StudentUpdate() {
    Student student = new Student(4L, "ana", "perez");
    Student studentEdit = new Student(4L, "Jose", "perez");
    when(repo.edit(studentEdit)).thenReturn(studentEdit);
    Student studentExpected = studentServiceImpl.edit(studentEdit);

    assertNotNull(studentExpected);
    assertNotEquals(student, studentExpected);
    assertEquals(studentEdit, studentExpected);
  }

  @Test
  public void deleteTest_shouldReturnTheStudentDelete_StudentIsDelete() {
    Student student = new Student(4L, "ana", "perez");
    when(repo.delete(student)).thenReturn(Boolean.TRUE);
    Boolean expected = studentServiceImpl.delete(student);

    assertEquals(true, expected);
  }


}