package com.example.test_Hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table

/*enrollments dovrebbe essere un entità che gestisce l'iscrizione di studenti a una classe*/
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true, updatable = true, name = "studentId", nullable = false)
    private long studentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true, updatable = true, name = "classId", nullable = false)
    private long classId;
}
