package com.mtgapp.mtgapp;
import java.io.IOException;

/**
 * Class Card that extends the class CollectibleItem.
 * Card is an object that hold information about the collectible item card.
 *
 */
public class Card extends CollectibleItem{
    /**
     * A string that has the cards color identity as its Wedges name.
     * Calculated in the manaToWedge() method.
     */
    public String color;
    /**
     * A String that has the Card type.
     *
     */
    public String type_line;
    /**
     * Converted Mana Cost
     * A integer that is calculated from the card mana_cost.
     */
    public Integer cmc;
    /**
     * String that has the cards mana cost.
     * the string is in a format like "{2}{G}"
     * The digits represent colorless mana, and the letters its mana symbols.
     */
    public String mana_cost;
    /**
     * String that has the artist who drew the card.
     */
    public String artist;
    /**
     * String that represents the set that the card is from.
     */
    public String set;
    /**
     * Double value that has the cards value.
     */
    public double value;
    /**
     * Boolean value that determines if a card is legendary.
     */
    public boolean legendary = false;
    /**
     * Oracle_Text
     * This string has the cards rule text as a string.
     */
    public String oracle_text = null;
    /**
     * String image_uri
     * this String is an URL to the image of the Card.
     */
    public String image_uri;
    /**
     * getImage_uri()
     * returns a String of the cards image_uri if its not null.
     * else returns a string "null"
     * @return
     */
    public String getImage_uri() {
        if (image_uri != null) {
        return image_uri;}
        else return "null";
    }
    /**
     * setImage_uri
     * Sets the Sting image_uri to the param string.
     * @param image_uri
     */
    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }
    /**
     * Set Converted Mana Cost.
     * After a card has been given a mana cost, that mana cost can be turned into a
     * converted mana cost that can prove useful.
     * A converted mana cost is a integer contrived from the regular mana_cost that is a String.
     *
     * This sets the Cards cmc to the param integer cmc.
     * @param cmc
     */
    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }
    /**
     * getCmc return the cards cmc as an integer.
     * if the mana_cost has a value and the cmc is null = has not been calculated yet,
     * it will be calculated before returning the int cmc value.
     * @return cmc
     */
    public int getCmc() {
        if (this.mana_cost != null) {
            if(this.cmc == null) {
                this.calcCMC();
                return cmc;
            }else return this.cmc;
        }
        return 0;
    }
    /**
     * getValue
     * Returns cards value as a double.
     * @return value
     */
    public double getValue() {
        return value;
    }
    /**
     * Sets the Cards value to Param double.
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }
    /**
     * Sets the cards legendary value to the param value.
     * @param legendary
     */
    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }
    /**
     * getOracle_text()
     * returns the cards oracle text, also known as rule text as a string.
     * @return
     */
    public String getOracle_text() {
        return oracle_text;
    }
    /**
     * setOracle_test
     * sets the cards oracle text, also known as its rule text.
     *
     * @param oracle_text
     */
    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }
    /**
     * isLegendary()
     * Return a Boolean value that reflects if the card is of the type, Legendary
     * Checks the type_line if it contains the String "legendary".
     * If yes the card is Legendary
     * @return isLegendary
     */
    public boolean isLegendary() {
        if(this.getType_line().toLowerCase().contains("legendary")){
            this.setLegendary(true);
        }
        return legendary;
    }

    /**
     * returns the Cards artist as a string.
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the cards artist to param
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * returns the cards set as a String.
     * @return set
     */
    public String getSet() {
        return set;
    }

    /**
     * Sets the cards Set to the String of the param.
     * @param set
     */
    public void setSet(String set) {
        this.set = set;
    }
    /**
     * Return the Cards Color as a String.
     * If mana_cost exists but color is somehow null it does a CMC calculation.
     * If color isnt null it returns color as a String.
     * else Return null
     * @return color
     */
    public String getColor() {
        if (this.color != null) {
            return this.color;
        }
        else if(this.color == null && this.mana_cost != null) {
            this.calcCMC();
            return this.color;
        }
        return null;
    }

    /**
     * Sets the cards color to param
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return the cards type_line as a String
     * @return type_line
     */
    public String getType_line() {
        return type_line;
    }

    /**
     * Sets the cards type line to the params String.
     * Checks if the new type_line is legendary.
     * @param type_line
     */
    public void setType_line(String type_line) {
        this.legendary = type_line.toLowerCase().contains("legendary");
        this.type_line = type_line;

    }

    /**
     * CopyFrom method
     * Copies the param Card's information to the card that called the method.
     * @param card
     */
    public void copyFrom(Card card) {
        this.color = card.color;
        this.type_line = card.type_line;
        this.cmc = card.cmc;
        this.mana_cost = card.mana_cost;
        this.artist = card.artist;
        this.set = card.set;
        this.value = card.value;
        this.legendary = card.legendary;
        this.oracle_text = card.oracle_text;
    }


    /**
     * Get mana cost.
     * Returns the String mana_cost of the Card
     * @return mana_cost
     */
    public String getMana_cost() {
        return mana_cost;
    }

    /**
     * setMana_cost
     * sets the cards mana cost to the param string.
     * should be in the format of "{2}{R}"
     * @param mana_cost
     */
    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
        this.calcCMC();
    }


    /**
     * Basic Constructor.
     * Creates a new Card Object with the name of the param.
     * @param name
     */
    public Card(String name) {
        super(name);
    }

    /**
     * Create Card Method Constructor.
     * Method that creates a Card object.
     * It will go through a LoadObject.loadCard method that checks if a card with the same name has already been saved.
     * If not the method will create a new card object.
     * Returns a Card object
     * @param cardName
     * @return card
     * @throws IOException
     */
    public static Card createCard(String cardName) throws IOException {
        Card card = LoadObject.loadCard(cardName);
        return card;
    }

    /**
     * Calculate Converted Mana Cost
     *
     * Method that calculated the Cards CMC from its mana_cost.
     * The mana cost is in a format like -> {2}{G}{R}
     * mana_cost string is parsed by first replaceing all brackets with a space,
     * then trimming the String so that no leading or trailing spaces are left.
     * Now the Cards example mana cost would be in this form -> 2GR
     * Then the Single Char Strings are places in the part[] array.
     *
     * Then for each part of the array we first check if the character is a digit.
     * If true then we add the digits to the cmc count as an integer.
     *
     * If the character is not a digit we simply raise the cmc count by 1.
     * This is because a single mana symbol is worth 1 cmc.
     * We ignore X since its worth 0.
     *
     * If the part array is longer than one it is a digit that is longer than 10.
     * Therefore, we simply add it as an integer
     *
     * After going through the array we will have an accurate CMC count.
     *
     * Since we are parsing through the mana_cost it is a good place to store the mana symbol values too
     * String colorss will be populated by the mana symbols as they are processed.
     * Then we will run the manaToWedge method to get cards mana wedge name.
     *
     * this.cmc will be int cmc.
     *
     */
    public void calcCMC() {
        if (this.mana_cost != null) {
            int cmc = 0;
            String colorss = "";
            String[] parts = this.mana_cost.replaceAll("[{}]", " ").trim().split("\\s+");

            for (String part : parts) {
                if (part.length() > 1) {
                    cmc += Integer.parseInt(part);
                }else if (Character.isDigit(part.charAt(0))) {
                    cmc += Integer.parseInt(part);

                } else if (!part.equalsIgnoreCase("X")) {
                    cmc += 1;
                    if (!colorss.contains(part)){
                        colorss += part;
                    }
                }
            }
            this.color = manaToWedge(colorss);
            this.cmc = cmc;
        }
        else System.out.println("Manacost is null");
    }

    /**
     * Mana to Wedge method.
     * Will return a Wedge name of the cards colors.
     * Simply the String color that has the mana symbols of a card will be put to a if else check that finds the right
     * mana wedge.
     * That mana wedge will be returned.
     * If the mana symbols doesnt have a mana symbol the color will be 'Colorless'
     * @param colors
     * @return color
     */
    public String manaToWedge(String colors){
        String wedge = "";
        if (colors != null) {
            String mana = colors;
            if (mana.equals("WUBRG")) {
                wedge = "5 Color";
            }
            // 4-color
            else if (mana.equals("WUBR")) {
                wedge = "Yore-Tiller";
            } else if (mana.equals("WUBG")) {
                wedge = "Witch-Maw";
            } else if (mana.equals("WURG")) {
                wedge = "Ink-Treader";
            } else if (mana.equals("WBRG")) {
                wedge = "Dune-Brood";
            } else if (mana.equals("UBRG")) {
                wedge = "Glint-Eye";
            }
            // 3-color Wedges
            else if (mana.equals("WUB")) {
                wedge = "Esper";
            } else if (mana.equals("UBR")) {
                wedge = "Grixis";
            } else if (mana.equals("BRG")) {
                wedge = "Jund";
            } else if (mana.equals("RGW")) {
                wedge = "Naya";
            } else if (mana.equals("GWU")) {
                wedge = "Bant";
            }
            // 3-color Shards
            else if (mana.equals("WUR")) {
                wedge = "Jeskai";
            } else if (mana.equals("UBG")) {
                wedge = "Sultai";
            } else if (mana.equals("BRW")) {
                wedge = "Mardu";
            } else if (mana.equals("RGU")) {
                wedge = "Temur";
            }
            // 2-color Guilds
            else if (mana.equals("WU")) {
                wedge = "Azorius";
            } else if (mana.equals("UB")) {
                wedge = "Dimir";
            } else if (mana.equals("BR")) {
                wedge = "Rakdos";
            } else if (mana.equals("RG")) {
                wedge = "Gruul";
            } else if (mana.equals("GW")) {
                wedge = "Selesnya";
            } else if (mana.equals("WB")) {
                wedge = "Orzhov";
            } else if (mana.equals("UR")) {
                wedge = "Izzet";
            } else if (mana.equals("BG")) {
                wedge = "Golgari";
            } else if (mana.equals("RW")) {
                wedge = "Boros";
            } else if (mana.equals("GU")) {
                wedge = "Simic";
            }
            // 1-color
            else if (mana.equals("W")) {
                wedge = "White";
            } else if (mana.equals("U")) {
                wedge = "Blue";
            } else if (mana.equals("B")) {
                wedge = "Black";
            } else if (mana.equals("R")) {
                wedge = "Red";
            } else if (mana.equals("G")) {
                wedge = "Green";
            }
            // Default case if no match is found
            else {
                wedge = "Colorless";
            }
        }

        return wedge; // Ensure you return the determined wedge
    }


    /**
     * Prints relevant information of the card.
     */
    public void print() {
        System.out.println("name: " + this.getName() + " type: " + this.getType_line() + ", color: " + this.getColor() + ", mana_cost: " + this.getMana_cost());
        System.out.println("oracle text: " + this.getOracle_text());
    }


}
