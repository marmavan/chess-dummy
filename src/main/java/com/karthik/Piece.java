package com.karthik;

import com.karthik.exceptions.InvalidMoveException;

import java.sql.Timestamp;
import java.time.Instant;

public abstract class Piece {
    protected Color color;
    protected int coordX;
    protected int coordY;
    boolean isAlive;
    public Piece(Color color, int coordX, int coordY) {
        this.color = color;
        this.coordX = coordX;
        this.coordY = coordY;
        this.isAlive = true;
    }

    public void move(int newCoordX, int newCoordY, Game game) throws InvalidMoveException {
        validateMove(game, newCoordX, newCoordY);

        performKillIfRequired(game, newCoordX, newCoordY);
        winGameIfConditionsMeet(game);

        game.getBoard()[coordX][coordY] = null;
        game.getLogEntries().add(new LogEntry(this, coordX, coordY, newCoordX, newCoordY, Timestamp.from(Instant.now())));
        coordX = newCoordX;
        coordY = newCoordY;
        game.getBoard()[coordX][coordY] = this;
    }

    private void winGameIfConditionsMeet(Game game) {
        game.getBoard()
                game.setInProgress();
    }

    private void performKillIfRequired(Game game, int newCoordX, int newCoordY) {
        if (game.getBoard()[newCoordX][newCoordY] != null &&
                game.getBoard()[newCoordX][newCoordY].getColor() != this.getColor()) {
            markKill(game, newCoordX, newCoordY);
        }
    }

    private void markKill(Game game, int newCoordX, int newCoordY) {
        game.getBoard()[newCoordX][newCoordY].setAlive(false);
        game.getBoard()[newCoordX][newCoordY] = null;
    }

    protected abstract void validateMove(Game game, int newCoordX, int newCoordY) throws InvalidMoveException;

    public Color getColor() {
        return color;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
