package com.mtgapp.mtgapp;
import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * Import Decklist
 *
 * A Class with a method that takes a txt file decklist and adds the cards in that file to a deck.
 */
public class ImportDecklist {


    /**
     * ParseDeck.
     * Takes a parameter of a decklist.txt's name. Searches it and starts to parse it to a List
     *
     * The Decklists are in a format like -> 1 Swamp
     * Line by line we read the file and split the line into 2 at the space.
     * First part is the amount of a card, the 2nd part is the name of the card.
     * if the line has more than 2 parts, there is a problem in the format of the deck and we dont accept it.
     * We use the createCard method to load or create a new Card.
     * We return a finished List of cards.
     *
     * @param deckListName
     * @return
     */
        public static List<Card> parseDeck(String deckListName) {
            String filePath = "src/main/resources/decklists/" + deckListName;
            List<Card> deck = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ", 2);
                    if (parts.length < 2) continue;
                    int count = Integer.parseInt(parts[0]);
                    String cardName = parts[1];

                    for (int i = 0; i < count; i++) {
                        Card card = Card.createCard(cardName);
                        deck.add(card);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            System.out.println("Decklist imported successfully.");
            return deck;
        }



}
