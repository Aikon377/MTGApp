package com.mtgapp.mtgapp;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {


        CommanderDeck kaima = new CommanderDeck("kaima", new Card("Kaima, the Fractured Calm"));
        CommanderDeck oloro = new CommanderDeck("oloro", "Oloro, Ageless Ascetic");

        System.out.println(oloro.getCommander().oracle_text);
        System.out.println(oloro.getDeckColor());



        System.out.println(kaima.getColors());

        try {
            test t = new test();
          // t.loadCardTest();
          // t.ImportDeckTest();
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
        Card rip = new Card("Rest in Peace");

        try {
            rip = LoadObject.loadCard(rip.getName());
            SaveObject.saveCard(rip);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
