package com.mtgapp.mtgapp;

import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {

        Card kaima = new Card("Kaima, the Fractured Calm");
        Deck deck = new Deck("Kaima");

        Card rip = new Card("Rest in Peace");

        kaima.setMana_cost("{2}{R}{G}");
        kaima.calcCMC();
        System.out.println(kaima.getColor());
        System.out.println(deck.deckDetails());
        System.out.println("deck colors: " + deck.getColors());

        Deck deck2 = new Deck("Deck 2");

        String deckName = "";


        deck2.setCards(ImportDecklist.parseDeck("src/main/resources/decklists/kaima"));

       // System.out.println(deck2.deckDetails());
        deck2.saveDeck();

        try {
            Deck deck3 = LoadCard.loadDeck(deck2.getName());
            deck3.deckDetails();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       // CardInfoAPI.getCardInfo(kaima);

        try {
            rip = LoadCard.loadCard(rip.getName());
            SaveObject.saveCard(rip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Card loadCard = LoadCard.loadCard(rip.getName());

        loadCard.print();


        // rip.print();
        // System.out.println(rip.getImage_uri());




    }
}
