package com.mtgapp.mtgapp;
import java.io.IOException;

/**
 * CommanderDeck Class
 * Extends Deck Class
 * Creates a deck that implements LegalDeck interface.
 * A Commander deck has a singular legendary creature as a commander.
 *
 */
public class CommanderDeck extends Deck implements LegalDeck {
    private Card commander;


    /**
     * Commander decks color is determined by its commander and this method does just that
     * It looks at the commanders colors and sets the decks colors to that Cards colors.
     */
    public void setDeckColor() {
        if (commander != null) {
            this.commander.calcCMC();
            this.setColors(commander.getColor());
        }
    }

    /**
     * Returns the decks colors.
     * @return deckColor
     */
    public String getDeckColor() {
        if (commander != null) {
            return commander.getColor();
        } else return "null color";
    }

    /**
     * Returns the decks commander as a Card
     * @return commander
     */
    public Card getCommander() {
        return commander;
    }

    /**
     * Sets the decks commander to a String.
     * Creates a new Card names param.
     * The card should be Legendary so that is also checked.
     * @param commander
     */
    public void setCommander(String commander) {
        try {
            Card commanderCard = LoadObject.loadCard(commander);
            if (commanderCard.isLegendary()) {
                this.commander = commanderCard;
                this.setDeckColor();
                this.removeCard(commanderCard);
                saveDeck();
            } else {
                System.out.println("CommanderDeck Error: Commander is not Legendary");
                this.commander = null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sets the Decks commander to a param Card.
     * @param commander
     */
    public void setCommander(Card commander) {
        try {
            commander = LoadObject.loadCard(commander.getName());
            if (commander.isLegendary()) {
                this.commander = commander;
                this.setDeckColor();
                this.removeCard(commander);
                this.setFormat("Commander");
                saveDeck();
            } else {
                System.out.println("CommanderDeck Error: Commander is not Legendary");
                this.commander = null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Constructor.
     * Creates a new Commander Deck with the name @param name, and with a commander @param commander
     * @param name
     * @param commander
     */
    public CommanderDeck(String name, Card commander) {
        super(name);
        this.setCommander(commander);
        this.setFormat("Commander");

    }

    /**
     * Constructor.
     * Creates a new Commander Deck with the name @param name,
     * and creates a new Card with the name @param commanderName, and sets it as commander.
     * @param name
     * @param commanderName
     */
    public CommanderDeck(String name, String commanderName) {
        super(name);
        try {
            this.setFormat("Commander");
            Card commander = LoadObject.loadCard(commanderName);
            setCommander(commander);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints decks details.
     */
    public void deckDetails() {
        this.refreshDetails();
        System.out.println(this);
    }

    /**
     * Boolean to see if the deck is legal to play.
     * @return
     */
    @Override
    public boolean isLegal() {
        if (this.getSize() != 99 || !this.commander.isLegendary()) {
            return false;
        } else return true;
    }
}
