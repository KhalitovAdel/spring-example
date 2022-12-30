package com.example.lal;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Lal {

    public enum LalType {
        FIRST, SECOND, THIRD
    }
    
    @Id @GeneratedValue @Getter 
    private Long id;

    @Getter
    private String name;

    @Getter @Enumerated(EnumType.STRING)
    private LalType type;

    public Lal() {
        this.name = "emptyName";
        this.type = LalType.FIRST;
    }

    public Lal(String name, LalType type) {
        this.name = name;
        this.type = type;
    }
}
