package com.mtgapp.mtgapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DeckSaver {

    public static void saveDeck(Deck deck) throws IOException {
        String path = "target/classes/decks" + File.separator + deck.getName() + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(deck);
            System.out.println("Deck saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}