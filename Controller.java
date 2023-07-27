package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    static HashMap<Character, Integer> letterValues = new HashMap<>();
    static ArrayList<String> previousWords = new ArrayList<>();

    public static void main(String[] args) {
        initializeLetterValues();
        Scanner scanner = new Scanner(System.in);

        int totalPoints = 0;

        while (true) {
            System.out.println("Insert word: ");
            String word = scanner.nextLine().toUpperCase();
            if (word.length() < 2) {
                System.out.println("Invalid length");
                continue;
            }
            boolean containsVowel = false;
            for (char c : word.toCharArray()) {
                if (isVowel(c)) {
                    containsVowel = true;
                    break;
                }
            }
            if (!containsVowel) {
                System.out.println("Vowel is required");
                continue;
            }
            if (word.length() > 8) {
                System.out.println("Exceeded the limit (8) ");
                continue;
            }
            if (previousWords.contains(word)) {
                System.out.println("Repetition ");
                continue;
            }

            previousWords.add(word);
            int wordPoints = calculatePoints(word);
            totalPoints += wordPoints;
            System.out.println("Points for \"" + word + "\": " + wordPoints);
            System.out.println("Total points: " + totalPoints);
            System.out.println("Previous words: " + previousWords.toString());
        }
    }

    public static boolean isVowel(char c) {
        // Check if the character is a vowel
        return "AEIOU".indexOf(c) != -1;
    }

    private static int calculatePoints(String word) {
        int points = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            points += letterValues.getOrDefault(letter, 0);
        }
        return points;
    }

    public static void initializeLetterValues() {
        letterValues.put('A', 1);
        letterValues.put('B', 3);
        letterValues.put('C', 3);
        letterValues.put('D', 2);
        letterValues.put('E', 1);
        letterValues.put('F', 4);
        letterValues.put('G', 2);
        letterValues.put('H', 4);
        letterValues.put('I', 1);
        letterValues.put('J', 8);
        letterValues.put('K', 5);
        letterValues.put('L', 1);
        letterValues.put('M', 3);
        letterValues.put('N', 1);
        letterValues.put('O', 1);
        letterValues.put('P', 3);
        letterValues.put('Q', 10);
        letterValues.put('R', 1);
        letterValues.put('S', 1);
        letterValues.put('T', 1);
        letterValues.put('U', 1);
        letterValues.put('V', 4);
        letterValues.put('W', 4);
        letterValues.put('X', 8);
        letterValues.put('Y', 4);
        letterValues.put('Z', 10);
    }
}
