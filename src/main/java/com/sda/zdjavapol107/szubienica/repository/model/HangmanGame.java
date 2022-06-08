package com.sda.zdjavapol107.szubienica.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hsqldb.rights.User;

import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class HangmanGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private HangmanUser gameUser;
    @OneToOne
    private HangmanSlogan slogan;

    public HangmanGame(HangmanUser gameUser, HangmanSlogan slogan) {
        this.gameUser = gameUser;
        this.slogan = slogan;
    }
}
