package com.example.demo.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @Column(name="ID")

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="PhoneNumber")
    private Long phoneNumber;
}

