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

    public static boolean saveCard(Card card) {
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
            return true;
        }
        return false;
    }



    public static void SaveDeck(Deck deck) {

        File file = new File("target/classes/decks/" + deck.getName() + ".deck");

        if (file.exists()) {
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Object existingFile = in.readObject();

                if (existingFile.equals(deck)) {
                    System.out.println("Deck already exists");
                    return;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

            try{
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(deck);
                System.out.println("Deck Saved");
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}
