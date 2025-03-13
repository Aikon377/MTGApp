package com.mtgapp.mtgapp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card extends CollectibleItem{
    public String color;
    public String type_line;
    public Integer cmc;
    public String mana_cost;
    public String ruleText;
    public String artist;
    public String set;
    public double value;
    public boolean legendary;
    public String oracle_text = null;
    public ImageUris image_uris;
    public String image_uri;

    public ImageUris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(ImageUris image_uris) {
        this.image_uris = image_uris;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    // Getters and setters
    public ImageUris getImageUris() {
        return image_uris;
    }

    public void setImageUris(ImageUris image_uris) {
        this.image_uris = image_uris;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    public String getOracle_text() {
        return oracle_text;
    }

    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }

    public boolean isLegendary() {
        return legendary;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.legendary = type_line.toLowerCase().contains("legendary");
        this.type_line = type_line;

    }
    public void copyFrom(Card card) {
        this.color = card.color;
        this.type_line = card.type_line;
        this.cmc = card.cmc;
        this.mana_cost = card.mana_cost;
        this.ruleText = card.ruleText;
        this.artist = card.artist;
        this.set = card.set;
        this.value = card.value;
        this.legendary = card.legendary;
        this.oracle_text = card.oracle_text;
    }

    public int getCmc() {
        return cmc;
    }

    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
        calcCMC();
    }



    public Card(String name) {
        super(name);


    }
    /*
    public static Card createCard(String cardName) {
        if (SaveObject.cardExists(new Card(cardName))) {
            return LoadCard.loadCard(new Card(cardName));
        }
    }

     */


    public void calcCMC() {
        if (this.mana_cost != null) {
            int cmc = 0;
            String colorss = "";
            String[] parts = this.mana_cost.replaceAll("[{}]", " ").trim().split("\\s+");

            for (String part : parts) {
                if (part.matches("\\d+")) {  // If it's a number
                    cmc += Integer.parseInt(part);
                } else if (!part.equalsIgnoreCase("X")) {  // If it's a mana symbol (excluding "X")
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


    public String manaToWedge(String mana){
        String wedge = "";
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

        return wedge; // Ensure you return the determined wedge
    }



    public void print() {
        System.out.println("name: " + this.getName() + " type: " + this.getType_line() + ", color: " + this.getColor() + ", mana_cost: " + this.getMana_cost());
        System.out.println("oracle text: " + this.getOracle_text());
    }


}
