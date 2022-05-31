package com.sda.zdjavapol107.checkers;

import com.sda.zdjavapol107.checkers.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
@AllArgsConstructor
@Getter
public class Pawn {
    private int pawnNumber;
    private Player player;
    private Character color;
    private boolean type;
    private boolean status;
    private Set<PawnMove> listOfMoves;



}
