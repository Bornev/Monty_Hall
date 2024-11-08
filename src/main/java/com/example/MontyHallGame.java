package com.example;

import java.util.HashMap;
import java.util.Random;

public class MontyHallGame {
    private final Random random = new Random();
    private HashMap<Integer, Boolean> results = new HashMap<>();

    public void runSimulation(int iterations) {
        int winsIfSwitched = 0;
        int winsIfStayed = 0;

        for (int i = 1; i <= iterations; i++) {
            boolean switchChoice = simulateGame(true);  // Победа при смене выбора
            boolean stayChoice = simulateGame(false);   // Победа без смены выбора

            if (switchChoice) winsIfSwitched++;
            if (stayChoice) winsIfStayed++;

            results.put(i, switchChoice);
        }

        System.out.println("Результаты: ");
        System.out.println("Победы при смене выбора: " + winsIfSwitched);
        System.out.println("Победы без смены выбора: " + winsIfStayed);
    }

    private boolean simulateGame(boolean switchChoice) {
        int prizeDoor = random.nextInt(3);   // Приз за одной из дверей (0, 1 или 2)
        int playerChoice = random.nextInt(3); // Игрок выбирает дверь
        int openedDoor = openNonPrizeDoor(prizeDoor, playerChoice); // Ведущий открывает дверь без приза

        if (switchChoice) {
            playerChoice = 3 - playerChoice - openedDoor; // Переключиться на другую дверь
        }
        return playerChoice == prizeDoor;
    }

    private int openNonPrizeDoor(int prizeDoor, int playerChoice) {
        int doorToOpen;
        do {
            doorToOpen = random.nextInt(3);
        } while (doorToOpen == prizeDoor || doorToOpen == playerChoice);
        return doorToOpen;
    }

    public HashMap<Integer, Boolean> getResults() {
        return results;
    }
}