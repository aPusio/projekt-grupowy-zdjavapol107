package com.sda.zdjavapol107.kolkokrzyzyk.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TTTMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer coordinateRow;
    private Integer coordinateCol;
    private char userSymbol;
    @ManyToOne
    private TTTGame game;
}
