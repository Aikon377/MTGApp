package com.mtgapp.mtgapp;
import java.io.Serializable;
import java.util.Date;
/**
 * Abstract class CollectibleItem.
 * A class that allows the program do create collectible item Objects
 * Class is Serializable and Collectible which allow us to Save and ensure all subclasses have
 * the important methods of Collectible objects.
 *
 */
public abstract class CollectibleItem implements Serializable, Collectible {

    /**
     * Name of the CollectibleItem
     */
    public String name;
    /**
     * Date the CollectibleItem was added / acquired.
     */
    public Date dateAcquired;
    /**
     * this is a String that represents the save location of the collectible item.
     * this is used to save, load and delete items.
     */
    public String save;
    /**
     * represents the owner of the CollectibleItem
     */
    public String owner;

    /**
     * returns the owner of the CollectibleItem
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the String owner as the owner of the CollectibleItem.
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Returns the path of the saved CollectibleItem if its not null.
     * Otherwise return a String -> "null"
     * @return save
     */
    public String getSave() {
        if (save != null) {
            return save;
        }
        else return "null";
    }

    /**
     * Sets param String as the path to the save of the CollectibleItem.
     * @param save
     */
    public void setSave(String save) {
        this.save = save;
    }


    /**
     * Returns the name of the CollectibleItem.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the String name as the name of the CollectibleItem.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the Date, dateAcquired of the CollectibleItem.
     * @return
     */
    public Date getDateAcquired() {
        return dateAcquired;
    }

    /**
     * sets the param Date dateAcquired as the CollectibleItems dateAcquired.
     * @param dateAcquired
     */
    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }


    /**
     * Creates a CollectibleItem object.
     * param name is inserted as the name of the object.
     * dateAcquired set as the time of creation.
     * @param name
     */
    public CollectibleItem(String name) {
        this.name = name;
        dateAcquired = new Date();
    }

    /**
     * Returns the basic information of the CollectibleItem as a string
     * @return toString
     */
    public String toString() {
        return "Name: " + getName() + ", Owner: " + owner + ", Date: " + getDateAcquired();
    }


}
