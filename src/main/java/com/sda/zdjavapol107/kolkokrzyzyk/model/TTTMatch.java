package com.sda.zdjavapol107.kolkokrzyzyk.model;

import com.sda.zdjavapol107.kolkokrzyzyk.dao.TTTMatchDao;
import com.sda.zdjavapol107.kolkokrzyzyk.other.Result;
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
public class TTTMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Result result;
    @ManyToOne
    private TTTMatch match;
    @OneToMany
    private List<TTTMove> moves;

}
