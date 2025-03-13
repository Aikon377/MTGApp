package com.mtgapp.mtgapp;

import java.util.List;

public class Deck extends CollectibleItem{
    private String colors;
    private String format;
    private String bracket;
    private String creator;
    private double value;
    private List<Card> cards;
    public int creatures;
    public int sorceries;
    public int instants;
    public int enchantments;
    public int lands;
    public int planeswalkers;
    private boolean foil;

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getBracket() {
        return bracket;
    }

    public void setBracket(String bracket) {
        this.bracket = bracket;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void printCards() {
        if (cards != null) {
            System.out.println("Deck: " + this.getName());
            System.out.println("--------");
            for (Card card : cards) {
                System.out.println(card.getName());
            }
            System.out.println("--------");
        }
    }


    public List<Card> getCards() {
        return cards;
    }

    public void deckDetails() {
        if (cards != null) {
            System.out.println("Deck: " + this.getName());
            for (Card card : cards) {
                System.out.println(card.getName());
            }
        }else System.out.println("Decks: " + this.getName() + " cardlist is null");
    }

    public void refreshDetails() {
        int lands = 0;
        int planeswalkers = 0;
        int enchantments = 0;
        int creatures = 0;
        int sorceries = 0;
        int instants = 0;

        if (this.cards != null) {
            for (Card card : cards) {
                card.calcCMC();

                if (card.getType_line().contains("Land")) {
                    lands++;
                }
                if (card.getType_line().contains("Planeswalker")) {
                    planeswalkers++;
                }
                if (card.getType_line().contains("Enchantment")) {
                    enchantments++;
                }
                if (card.getType_line().contains("Creature")) {
                    creatures++;
                }
                if (card.getType_line().contains("Sorcery")) {
                    sorceries++;
                }
                if (card.getType_line().contains("Instant")) {
                    instants++;
                }
            }
            this.lands = lands;
            this.enchantments = enchantments;
            this.creatures = creatures;
            this.sorceries = sorceries;
            this.instants = instants;
            this.planeswalkers = planeswalkers;
        }
    }

    public void saveDeck() {
        SaveObject.SaveDeck(this);
    }

    public Deck(String name) {
        super(name);
    }

}
