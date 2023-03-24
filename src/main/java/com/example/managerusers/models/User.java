package com.example.managerusers.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name="nombre", nullable=false)
    private String name;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="prioridad", length=11, nullable=false)
    private Integer priority;
}
