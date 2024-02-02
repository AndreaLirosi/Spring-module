package com.example.test_Hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // questa classe è una classe di entità JPA, che verrà mappata su una tabella nel database.
@Table  // Specifica che la classe sarà mappata a una tabella nel database
@Data   //  Annotazione di Lombok che genera automaticamente i metodi (come toString, equals) per tutti i campi della classe
@NoArgsConstructor  //  Annotazione di Lombok che genera un costruttore senza argomenti
@AllArgsConstructor //  Annotazione di Lombok che genera un costruttore con tutti gli argomenti.

public class Students {

    @Id // si genera una id come chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // si imposta il metodo auto per generare l'id

    private long id;
    @Column(name = "firstName")
    private String firstname;
    @Column(name = "lastName")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(unique = true, name = "email")  // specifica delle proprietà come l'unicità e il nome della colonna
        // fetch indica il caricamento "pigro" dei dati: ciò intenden che i dati vengono caricati solo quando si tenta di accedere ad essi, piuttosto che essere caricati subito.
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
