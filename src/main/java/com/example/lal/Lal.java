package com.example.lal;

import jakarta.persistence.*;

@Entity
public class Lal {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
