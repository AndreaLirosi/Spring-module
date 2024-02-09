package com.example.test_Hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Classroom {

    @OneToMany(mappedBy = "Class")
    private List<Enrollments> enrollments;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_class;
    private String title;
    private String description;
}
