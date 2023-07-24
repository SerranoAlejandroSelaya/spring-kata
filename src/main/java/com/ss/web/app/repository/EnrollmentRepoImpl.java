package com.ss.web.app.repository;

import com.ss.web.app.model.Enrollment;
import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class EnrollmentRepoImpl implements EnrollmentRepo {

  private List<Enrollment> college;

  public EnrollmentRepoImpl() {
    college = fillCollege();
  }

  private List<Enrollment> fillCollege() {
    List<Enrollment> result = new ArrayList<>();
    Subject math = new Subject(101L, "Math", "It's math");
    Subject programming = new Subject(103L, "Programming", "It's programming");
    Subject physics = new Subject(102L, "Physics", "It's physics");

    Student first = new Student(201L, "Next", "Test");
    Student second = new Student(202L, "Curl", "Test");
    Student third = new Student(203L, "Sho", "Test");

    result.add(new Enrollment(math, first));
    result.add(new Enrollment(math, third));
    result.add(new Enrollment(programming, first));
    result.add(new Enrollment(programming, second));
    result.add(new Enrollment(physics, second));
    result.add(new Enrollment(physics, third));

    return result;
  }

  @Override
  public List<Student> listStudents(Subject subject) {
    return college.stream()
            .filter(c -> c.getSubject().getCode().equals(subject.getCode()))
            .map(Enrollment::getStudent)
            .collect(Collectors.toList());
  }

  @Override
  public List<Subject> listSubjects(Student student) {
    return college.stream()
            .filter(c -> c.getStudent().getId().equals(student.getId()))
            .map(Enrollment::getSubject)
            .collect(Collectors.toList());
  }

  @Override
  public List<Student> listStudents(Long id) {
    return college.stream()
            .filter(c -> c.getSubject().getCode().equals(id))
            .map(Enrollment::getStudent)
            .collect(Collectors.toList());
  }

  @Override
  public List<Subject> listSubjects(Long id) {
    return college.stream()
            .filter(c -> c.getStudent().getId().equals(id))
            .map(Enrollment::getSubject)
            .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EnrollmentRepoImpl that = (EnrollmentRepoImpl) o;
    return Objects.equals(college, that.college);
  }

  @Override
  public int hashCode() {
    return Objects.hash(college);
  }
}
