package com.mtgapp.mtgapp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Load Object Class
 *
 * Class that has methods that loads objects from file to the program to use.
 * Class has 2 methods
 * loadCard searches for a Card by its name from the cards directory and returns it.
 * loadDeck searches for a Deck by its name from the decks directory and returns it.
 *
 */
public class LoadObject {

    /**
     * loadCard()
     * method that attempts to load a Card object with the param cardName from the directory cards.
     * if the card is not found a new card with the param card name is created.
     * Return a Card with the name of param.
     * @param cardName
     * @return Card
     * @throws IOException
     */
    public static Card loadCard(String cardName) throws IOException {
        File file = new File("target/classes/cards/" + cardName + ".card");
        if(file.exists()){
           try{
               ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
               Card card2 = (Card) in.readObject();
               /*
               if (card2.oracle_text == null) {
                   System.out.println("Card oracle_text is empty, fetching new info... ");
                   CardInfoAPI.getCardInfo(card2);
                   SaveObject.saveCard(card2);
               }
                */
               in.close();
               return card2;
           } catch (IOException | ClassNotFoundException e) {
               throw new RuntimeException(e);
           }
       }else {
            Card card = new Card(cardName);
            /*
            CardInfoAPI.getCardInfo(card)
             */
            SaveObject.saveCard(card);
            return card;
        }
    }

    /**
     * Attempt to load a deck from the decks directory with the name of the param String.
     * If it cannot find one, a new deck is created.
     * @param deckName
     * @return Deck
     * @throws IOException
     */
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
            return new Deck(deckName);
        }

    }

}
