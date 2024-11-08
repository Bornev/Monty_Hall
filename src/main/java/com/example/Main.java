package com.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        int iterations = 1000;
        game.runSimulation(iterations);

        HashMap<Integer, Boolean> results = game.getResults();
        // System.out.println("Результаты игры по шагам: " + results);
    }
}