package com.mtgapp.mtgapp;

import java.io.File;

public class DeleteObject {

    public static void deleteObject(CollectibleItem file) {

        if (file.getSave() != null) {
        File f = new File(file.getSave());
        if (f.delete()) {
            System.out.println("deleted file " + file.name + " successfully");
        }else System.out.println("couldn't delete file " + file);
        }else System.out.println("Cant delete file. filepath is null.");

    }
}
