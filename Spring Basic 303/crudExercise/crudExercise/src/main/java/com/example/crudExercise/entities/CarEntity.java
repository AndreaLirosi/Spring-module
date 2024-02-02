
package com.example.crudExercise.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Car")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CarEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String modelName;
    @Column
    private String type;


}
