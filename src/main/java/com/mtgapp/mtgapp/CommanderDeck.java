package com.mtgapp.mtgapp;

import java.io.IOException;

public class CommanderDeck extends Deck implements LegalDeck {
    private Card commander;

    public void setDeckColor() {
        if (commander != null) {
            this.commander.calcCMC();
            this.setColors(commander.getColor());
        }
    }

    public String getDeckColor() {
        if (commander != null) {
            return commander.getColor();
        } else return "null color";
    }

    public Card getCommander() {
        return commander;
    }

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

    public void setCommander(Card commander) {
        try {
            commander = LoadObject.loadCard(commander.getName());
            if (commander.isLegendary()) {
                this.commander = commander;
                this.setDeckColor();
                this.removeCard(commander);
                saveDeck();
            } else {
                System.out.println("CommanderDeck Error: Commander is not Legendary");
                this.commander = null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CommanderDeck(String name, Card commander) {
        super(name);
        setCommander(commander);

    }


    public CommanderDeck(String name, String commanderName) {
        super(name);
        try {
            Card commander = LoadObject.loadCard(commanderName);
            setCommander(commander);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deckDetails() {
        this.refreshDetails();
    }


    @Override
    public boolean isLegal() {
        if (this.getSize() != 99 || !this.commander.isLegendary()) {
            return false;
        } else return true;
    }
}
