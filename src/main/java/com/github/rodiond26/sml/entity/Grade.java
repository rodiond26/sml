package com.github.rodiond26.sml.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "grade_dict")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long id;
    @Column(name = "grade_text")
    private String text;
    @Column(name = "min_value")
    private Double minValue;
    @Column(name = "max_value")
    private Double maxValue;
}
