package com.example.test_Hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table

/*enrollments dovrebbe essere un entità che gestisce l'iscrizione di studenti a una classe*/
public class enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true, name = "studentId", nullable = false)
    private long studentId;


    @Column(unique = true, name = "classId", nullable = false)
    private long classId;
}
