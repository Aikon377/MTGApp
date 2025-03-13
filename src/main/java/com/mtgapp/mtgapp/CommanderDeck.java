package com.mtgapp.mtgapp;

public class CommanderDeck extends Deck {
    private Card commander;

    public void setDeckColor(){
        if (commander != null) {
            this.commander.calcCMC();
            this.setColors(commander.getColor());
        }
    }
    public CommanderDeck(String name, Card commander) {
        super(name);
        if (commander.isLegendary()){
            this.commander = commander;
            this.commander.calcCMC();
            this.setDeckColor();
        }
        else System.out.println("CommanderDeck Error: Commander is not Legendary");
    }

    public CommanderDeck(String name) {
        super(name);
    }

    public String deckDetails() {
        this.refreshDetails();
        return ("Commander: " + this.commander.getName() + ", Lands: " + this.lands + ", Creatures: " + this.creatures + ", Enchantments: " + this.enchantments + ", Sorceries: " + this.sorceries + ", Instants: " + this.instants +  ", Planeswalkers: " + this.planeswalkers);
    }


}
