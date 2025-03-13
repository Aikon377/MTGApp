package com.mtgapp.mtgapp;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public abstract class CollectibleItem implements Serializable, Collectible {

    public String name;
    public Date dateAcquired;
    public String save;
    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public CollectibleItem(String name) {
        this.name = name;
        dateAcquired = new Date();
    }
    public String getDetails() {
        return "Name: " + getName() + ", Date: " + getDateAcquired();
    }


}
