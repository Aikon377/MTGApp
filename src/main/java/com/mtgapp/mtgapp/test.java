package com.mtgapp.mtgapp;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {

       Deck deck = new Deck("Deck");
       deck.printCards();

        try {
            test t = new test();
            t.testCommanderDecks();
            t.loadCardTest();
            t.ImportDeckTest();
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
        //
    }
    public void loadCardTest() throws IOException {

        try {
            Card rip = Card.createCard("Rest in Peace");
            rip = LoadObject.loadCard(rip.getName());
            System.out.println(rip.getOracle_text());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void testCommanderDecks() throws IOException {

        CommanderDeck kaima = new CommanderDeck("kaima", "Kaima, the Fractured Calm");
        System.out.println("kaima pth: " + kaima.getSave());
        DeleteObject.deleteObject(kaima);

    }
}
