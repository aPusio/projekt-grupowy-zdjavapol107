package com.sda.zdjavapol107.szubienica.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HangmanSlogan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany
//            (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(
//            name = "join",
//            joinColumns = @JoinColumn(name = "HangmanSlogan_id"),
//            inverseJoinColumns = @JoinColumn(name = "HangmanGame_id")
//    )
    private Set<HangmanGame> game = new HashSet<>();

    public HangmanSlogan(String name) {
        this.name = name;
    }
}