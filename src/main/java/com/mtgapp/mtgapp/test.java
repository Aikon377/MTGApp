package com.mtgapp.mtgapp;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Class with tests.
 */
public class test {

    public static void main(String[] args) throws IOException {
        PriorityQueue<test> pq = new PriorityQueue<test>();

       Deck deck = new Deck("Deck");
       deck.printCards();

        try {
            test t = new test();
            t.testCommanderDecks();
            //t.loadCardTest();
            //t.ImportDeckTest();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void ImportDeckTest() {
        Deck importDeckTest = new Deck("importDeckTest");
        importDeckTest.setCards(ImportDecklist.parseDeck("kaima"));
        // System.out.println(deck2.deckDetails());
        importDeckTest.saveDeck();
        try {
            Deck decktest = LoadObject.loadDeck(importDeckTest.getName());
            decktest.refreshDetails();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadCardTest() throws IOException {

        try {
            Card rip = Card.createCard("Rest in Peace");
            rip = LoadObject.loadCard(rip.getName());
            System.out.println(rip.getOracle_text());
            System.out.println(rip.getImage_uri());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void testCommanderDecks() throws IOException {

        CommanderDeck kaima = new CommanderDeck("kaima", "Kaima, the Fractured Calm");

        System.out.println(kaima.getDeckColor());
        DeleteObject.deleteObject(kaima);

    }
}
