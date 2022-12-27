package com.example.lal;

import javax.persistence.*;

@Entity
public class Lal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public String getName() {
        return this.name;
    }
}
