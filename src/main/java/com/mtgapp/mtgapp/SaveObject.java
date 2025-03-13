package com.mtgapp.mtgapp;

import java.io.*;

public class SaveObject {


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

    public static boolean cardExists(String cardName) {
        String dirPath = "target/classes/cards/";
        File file = new File(dirPath + cardName + ".card");



        if (file.exists()) {
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Card existingFile = (Card) in.readObject();
                if (existingFile != null && cardName.equals(existingFile.getName())) {
                    System.out.println("card already exists");
                    return true;
                }else return false;
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else return true;
    }

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
                System.out.println("Card " + card.getName() + " saved");
                card.setSave(file.getAbsolutePath());
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }



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
