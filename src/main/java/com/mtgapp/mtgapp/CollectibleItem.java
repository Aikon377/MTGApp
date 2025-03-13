package com.mtgapp.mtgapp;

import java.io.Serializable;
import java.util.Date;

public abstract class CollectibleItem implements Serializable {

    public String name;
    public Date dateAcquired;

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
