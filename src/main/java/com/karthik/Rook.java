package com.karthik;

import com.karthik.exceptions.InvalidMoveException;

public class Rook extends Piece {

    public Rook(Color color, int coordX, int coordY) {
        super(color, coordX, coordY);
    }

    @Override
    protected void validateMove(Game game, int newCoordX, int newCoordY) throws InvalidMoveException {
        validateMovesUp(game, newCoordX, newCoordY);
        validateMovesDown(game, newCoordX, newCoordY);
        validateMovesRight(game, newCoordX, newCoordY);
        validateMovesLeft(game, newCoordX, newCoordY);
    }

    private void validateMovesLeft(Game game, int newCoordX, int newCoordY) throws InvalidMoveException {
        if (coordY == newCoordY) {
            int intermediateX = coordX;
            while (intermediateX > newCoordX) {
                if (game.getBoard()[intermediateX--][coordY] != null) {
                    throw new InvalidMoveException();
                }
            }
        }
    }

    private void validateMovesRight(Game game, int newCoordX, int newCoordY) throws InvalidMoveException {
        if (coordY == newCoordY) {
            int intermediateX = coordX;
            while (intermediateX < newCoordX) {
                if (game.getBoard()[intermediateX++][coordY] != null) {
                    throw new InvalidMoveException();
                }
             }
        }
    }

    private void validateMovesDown(Game game, int newCoordX, int newCoordY) throws InvalidMoveException {
        if (coordX == newCoordX) {
            int intermediateY = coordY;
            while (intermediateY > newCoordY) {
                if (game.getBoard()[coordX][intermediateY--] != null) {
                    throw new InvalidMoveException();
                }
            }
        }
    }

    private void validateMovesUp(Game game, int newCoordX, int newCoordY) throws InvalidMoveException {
        if (coordX == newCoordX) {
            int intermediateY = coordY;
            while (intermediateY < newCoordY) {
                if (game.getBoard()[coordX][intermediateY++] != null) {
                    throw new InvalidMoveException();
                }
            }
        }

    }
}
