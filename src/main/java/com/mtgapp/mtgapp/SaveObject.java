package com.mtgapp.mtgapp;
import java.io.*;

/**
 * Class SaveObject.
 * Includes methods aimed at and assisting in saving objects to file.
 */
public class SaveObject {

/*

    public static boolean doesDeckExist(Deck deck) {
        File file = new File("target/classes/decks/" + deck.getName() + ".deck");

        if (file.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Object existingFile = in.readObject();

                if (existingFile.equals(deck)) {
                    System.out.println("Deck already exists");
                    return true;
                }
            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
 */

    /**
     * cardExists()
     * a boolean method that checks if a card that is trying to be saved is already in the cards directory.
     * if yes returns true.
     * @param card
     * @return
     */
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

    /**
     * saveCard()
     *
     * Takes as a parameter a Card object and attempt to save it to the cards directory.
     * if the directory doesnt exists it is created.
     * If a card with the same name exists in the directory it will not be saved.
     * uses card.setSave to save the files location.
     * @param card
     */
    public static void saveCard(Card card) {
        String dirPath = "target/classes/cards/";
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Creating directory" + dirPath);
            dir.mkdirs();
        }
        File file = new File(dirPath + card.getName() + ".card");
        if (cardExists(card)) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(card);
                card.setSave(file.getAbsolutePath());
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * SaveDeck()
     * Attempts to save the param Deck to the directory decks.
     * if the directory doesnt exists it is created.
     *
     * @param deck
     */
    public static void SaveDeck(Deck deck) {

        String dirPath = "target/classes/decks/";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("creating directory " + dirPath);
            dir.mkdirs();
        }
        File file = new File(dirPath + deck.getName() + ".deck");
        
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
                deck.setSave(file.getAbsolutePath());
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
