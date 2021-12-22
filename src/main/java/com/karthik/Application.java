package com.karthik;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        Player player1 = new Player("Alex", getColor());
        Player player2 = new Player("Alexa", getComplementColor(player1));
        Game game = new Game(player1, player2);
        while(game.getInProgress()) {
            player1.requestMove(game);
            if (game.getInProgress()) {
                player2.requestMove(game);
            }
        }
    }

    private static Color getComplementColor(Player player1) {
        Optional<Color> colorOptional = Arrays.stream(Color.values()).filter(color -> player1.getColor().equals(color)).findFirst();
        return colorOptional.get();
    }

    private static Color getColor() {
        if (new Random().nextBoolean()) {
            return Color.White;
        }
        return Color.Black;
    }
}
