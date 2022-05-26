package com.sda.zdjavapol107.checkers;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Turnament {

    @Id
    private Long id;
    @JoinColumn(name = "id")
    private Player player_id;
    private Long score;

}
