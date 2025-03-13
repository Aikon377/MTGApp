package com.mtgapp.mtgapp;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadObject {

    public static Card loadCard(String cardName) throws IOException {

        File file = new File("target/classes/cards/" + cardName + ".card");

        if(file.exists()){
           try{
               ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
               Card card2 = (Card) in.readObject();
               if (card2.oracle_text == null) {
                   System.out.println("Card oracle_text is empty, fetching new info... ");
                   CardInfoAPI.getCardInfo(card2);
                   SaveObject.saveCard(card2);
               }
               return card2;

           } catch (IOException | ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
       }else {
            System.out.println("Fetching new info... ");
            Card card = new Card(cardName);
            CardInfoAPI.getCardInfo(card);
            SaveObject.saveCard(card);
            return card;
        }
    }

    public static Deck loadDeck(String deckName) throws IOException {
        File file = new File("target/classes/decks/" + deckName + ".deck");
        if(file.exists()){
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Deck existingFile = (Deck) in.readObject();
                return existingFile;

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("load failed");
            return null;
        }

    }

    public static Deck loadCommanderDeck(String deckName) throws IOException {
        File file = new File("target/classes/decks/" + deckName + ".cmd_deck");
        if(file.exists()){
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                CommanderDeck existingFile = (CommanderDeck) in.readObject();
                return existingFile;

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("load failed");
            return null;
        }

    }
}
