package com.example.company.Entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stagiaires")
@Data
public class Stagiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "employee_id") // Assuming the column name in the table is "employee_id"
    private Employee encadrerPar; // Rename the variable to encadrerPar

    public Stagiaire() {
    }

    public Stagiaire(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters (lombok takes care of these)
}
