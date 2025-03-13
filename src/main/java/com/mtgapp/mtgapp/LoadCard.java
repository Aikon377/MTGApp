package com.mtgapp.mtgapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCard {

    public static Card loadCard(String cardName) throws IOException {

        File file = new File("target/classes/cards/" + cardName + ".card");

        if(file.exists()){
           try{
               ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
               Card card2 = (Card) in.readObject();
               if (card2.oracle_text == null) {
                   System.out.println("Card oracle_text is empty, fetching info... ");
                   CardInfoAPI.getCardInfo(card2);
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
        }
        System.out.println("Load failed");
        return null;

    }

    public static Deck loadDeck(String deckName) throws IOException {
        File file = new File("target/classes/decks/" + deckName + ".deck");

        if(file.exists()){
            try{
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                Object existingFile = in.readObject();
                return (Deck) existingFile;

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("load failed");
        return null;

    }
}
