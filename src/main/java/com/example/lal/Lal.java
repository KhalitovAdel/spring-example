package com.example.lal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter 
@Entity
public class Lal {

    public enum LalType {
        FIRST, SECOND, THIRD
    }
    
    @Id @GeneratedValue 
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private LalType type;

    public Lal() {
        this.name = "emptyName";
        this.type = LalType.FIRST;
    }

    public Lal(String name, LalType type) {
        this.name = name;
        this.type = type;
    }

    @ManyToMany
    @JoinTable(
        name = "lal_kek", 
        joinColumns = @JoinColumn(name = "lal_id"), 
        inverseJoinColumns = @JoinColumn(name = "kek_id")
    )
    private List<Kek> keks = new ArrayList<Kek>();

    public Lal addKek(Kek k) {
        this.keks.add(k);
        
        return this;
    }
}
