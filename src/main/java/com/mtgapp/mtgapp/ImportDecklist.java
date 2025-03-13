package com.mtgapp.mtgapp;
import java.io.*;
import java.util.*;

public class ImportDecklist {

        public static List<Card> parseDeck(String deckListName) {
            String filePath = "src/main/resources/decklists/" + deckListName;

            List<Card> deck = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ", 2); // Splits at the first space
                    if (parts.length < 2) continue; // Skip invalid lines

                    int count = Integer.parseInt(parts[0]); // First part is quantity
                    String cardName = parts[1]; // Second part is card name

                    for (int i = 0; i < count; i++) {
                        Card card = Card.createCard(cardName);
                        deck.add(card); // Create Card objects
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Decklist imported successfully.");
            return deck;
        }

}
