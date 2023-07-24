package com.ss.web.app.model;

import java.util.Objects;

public class Subject {
  private Long code;
  private String title;
  private String description;

  public Subject(Long code, String title, String description) {
    this.code = code;
    this.title = title;
    this.description = description;
  }

  public Long getCode() {
    return code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Subject subject = (Subject) o;
    return Objects.equals(code, subject.code) && Objects.equals(title, subject.title) && Objects.equals(description, subject.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, title, description);
  }
}
