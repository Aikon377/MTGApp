package com.mtgapp.mtgapp;

import java.io.*;

public class SaveObject {


    public static void doesDeckExist(Deck deck) {
        File file = new File("target/classes/decks/" + deck.getName() + ".deck");

        if (file.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Object existingFile = in.readObject();

                if (existingFile.equals(deck)) {
                    System.out.println("Deck already exists");
                    return;
                }
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean cardExists(Card card) {
        File file = new File("target/classes/cards/" + card.getName() + ".card");

        if (file.exists() && card.oracle_text != null) {
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Object existingFile = in.readObject();

                if (existingFile.equals(card)) {
                    System.out.println("card already exists");
                    return false;

                }else return true;
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public static void saveCard(Card card) {
        File file = new File("target/classes/cards/" + card.getName() + ".card");
        if (cardExists(card)) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(card);
                System.out.println("Card " + card.getName() + " saved");
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



    public static void SaveDeck(Deck deck) {

        File file = new File("target/classes/decks/" + deck.getName() + ".deck");

        if (file.exists()) {
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Deck existingFile = (Deck) in.readObject();
                if (deck.equals(existingFile)) {
                    System.out.println("Deck " + deck.getName()+ " already exists.");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(deck);
                System.out.println("Deck " + deck.getName() + " saved.");
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
