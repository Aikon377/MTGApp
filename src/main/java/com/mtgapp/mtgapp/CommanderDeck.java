package com.mtgapp.mtgapp;

import java.io.IOException;

public class CommanderDeck extends Deck {
    private Card commander;

    public void setDeckColor(){
        if (commander != null) {
            this.commander.calcCMC();
            this.setColors(commander.getColor());
        }
    }
    public String getDeckColor(){
        if (commander != null) {
            return commander.getColor();
        }
        else return "";
    }

    public Card getCommander() {
        return commander;
    }

    public void setCommander(Card commander) {
        try {
            commander = LoadObject.loadCard(commander.getName());
            if (commander.isLegendary()) {
                this.commander = commander;
                this.setDeckColor();
                saveDeck();
            }else {
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


}
