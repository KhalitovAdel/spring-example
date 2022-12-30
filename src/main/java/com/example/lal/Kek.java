package com.example.lal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
public class Kek {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "keks")
    private List<Lal> lals = new ArrayList<Lal>();

    public Kek() {
        this.name = "emptyName";
    }

    public Kek(String name) {
        this.name = name;
    }

    public Kek addLal(Lal l) {
        this.lals.add(l);
        
        return this;
    }
}
