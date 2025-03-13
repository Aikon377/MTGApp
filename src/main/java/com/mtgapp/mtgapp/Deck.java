package com.mtgapp.mtgapp;
import java.util.Date;
import java.util.List;

/**
 * Deck Class
 * a collectibleItem Deck
 * a Deck is an object that hosts a List of cards and other relevant information about the deck.
 *
 */
public class Deck extends CollectibleItem{
    /**
     * String of the colors of the deck
     */
    private String colors;
    /**
     *
    String of the format of the deck.
     */
    private String format;
    /**
     * String of the bracket of the deck
     */
    private String bracket;
    /**
     * String of the creator of the deck.
     */
    private String creator;
    /**
     * String of the value of the deck.
     */
    private double value;
    /**
     * A List that has the Cards associated with the deck.
     */
    private List<Card> cards;
    /**
     * Count of the creatures in the deck.
     */
    public int creatures;
    /**
    count of the sorceries in the deck.
     */
    public int sorceries;
    /**
     * count of the instant in the deck
     */
    public int instants;
    /**
     * count of the enchantments in the deck
     */
    public int enchantments;
    /**
     * count of the lands in the deck
     */
    public int lands;
    /**
     * count of the planeswalkers in the deck.
     */
    public int planeswalkers;

    /**
     * size of the deck.
     */
    private int size = 0;

    /**
     * returns the size of the deck.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * sets the size of the deck. Unuseful.
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Sets the list that has the cards of the deck.
     *
     * @param cards
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Returns the colors of the deck.
     * @return colors
     */
    public String getColors() {
        return colors;
    }

    /**
     * sets the colors of the deck
     * @param colors
     */
    public void setColors(String colors) {
        this.colors = colors;
    }

    /**
     * returns the double of the value of the deck.
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the deck to param
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns the cretor of the deck
     * @return
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the creator of the deck
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Returns the bracket of the deck
     * @return
     */
    public String getBracket() {
        return bracket;
    }

    /**
     * Sets the bracket of the deck
     * @param bracket
     */
    public void setBracket(String bracket) {
        this.bracket = bracket;
    }

    /**
     * returns the format of the deck
     * @return
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the deck.
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * addCard()
     * Adds the param Card object to the deck.
     * Increases deck size.
     * @param card
     */
    public void addCard(Card card) {
        if (cards.add(card)){
            this.size = cards.size();
        }
    }

    /**
     * Removes the param Card from the deck.
     * @param card
     */
    public void removeCard(Card card) {
        if (!(this.cards == null)) {
            if (this.cards.remove(card)) {
                this.size = cards.size();
            }
        }
    }

    /**
     * Print to console each card in the deck.
     */
    public void printCards() {
        if (cards != null) {
            System.out.println("Deck: " + this.getName());
            System.out.println("--------");
            for (Card card : cards) {
                System.out.println(card.getName());
            }
            System.out.println("--------");
        }else System.out.println("Deck is empty");
    }

    /**
     * Returns as a List the list of cards of the deck.
     * @return List
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Prints some details of the deck to terminal.
     */
    public void deckDetails() {
        if (cards != null) {
            System.out.println("Deck: " + this.getName());
            for (Card card : cards) {
                System.out.println(card.getName());
            }
        }else System.out.println("Decks: " + this.getName() + " cardlist is null");
    }

    /**
     * Refreshes the details of the deck.
     * Calculates how many of each card type is in the deck.
     * Saves those values to the decks data.
     */
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

    /**
     * Method that saves the deck. Easy to call.
     */
    public void saveDeck() {
        SaveObject.SaveDeck(this);
    }

    /**
     * Constructor
     * Basic deck. Creates a deck with just a name.
     * @param name
     */
    public Deck(String name) {
        super(name);
    }

    /**
     * Creates a copy of the param deck. Names the param name.
     * @param deck
     * @param name
     */
    public Deck(Deck deck, String name) {
        super(name);
        this.setOwner(deck.getOwner());
        this.setCards(deck.getCards());
        this.setSize(deck.getSize());
        this.setColors(deck.getColors());
        this.setFormat(deck.getFormat());
        this.setBracket(deck.getBracket());
        this.setCreator(deck.getCreator());
        this.setCreator(deck.getCreator());
        this.setDateAcquired(new Date());
    }

}
