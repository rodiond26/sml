package com.github.rodiond26.sml.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_birth")
    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_grade")
    @ToString.Exclude
    @JsonIgnore
    private Grade grade;

    @JsonProperty(value = "grade")
    public String getGrade() {
        return this.grade != null
                ? this.grade.getText()
                : "";
    }

    @JsonIgnore
    public void setGrade(String grade) {
    }
}
