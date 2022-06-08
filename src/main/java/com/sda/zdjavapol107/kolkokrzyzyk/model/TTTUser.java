package com.sda.zdjavapol107.kolkokrzyzyk.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TTTUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer wonMatches;
    private Integer lostMatches;
    private Integer drawMatches;
    @OneToMany
    private List<TTTMatch> matches;
}
