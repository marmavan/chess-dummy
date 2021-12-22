package com.karthik;

import com.karthik.exceptions.InvalidMoveException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private List<Piece> pieces;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        initPieces(color);
    }

    private void initPieces(Color color) {
        if (color == Color.White) {
            pieces = Arrays.asList(new Rook(color, 0,0), new Rook(color, 7, 7));
        }
    }


    public Color getColor() {
        return color;
    }

    public void requestMove(Game game) {
        // Take input piece, X, Y
        Piece piece = new InputStreamReader().read();
        int destX = 7;
        int destY = 7;
        try {
            piece.move(destX, destY, game);
        } catch (InvalidMoveException e) {
            System.out.println("Invalid move");
            requestMove(game);
        }
    }
}
