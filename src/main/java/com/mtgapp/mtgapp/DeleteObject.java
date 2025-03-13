package com.mtgapp.mtgapp;

import java.io.File;

/**
 * Class DeleteObject
 * With one method: deleteObject(), its is a class designed to search and attempt to delete a file from a directory.
 */
public class DeleteObject {

    /**
     * deleteObject()
     *
     * takes in as a parameter a CollectibleItems file, if the save exists the method will attempt to delete it.
     * @param file
     */
    public static void deleteObject(CollectibleItem file) {
        if (file.getSave() != null) {
        File f = new File(file.getSave());
        if (f.delete()) {
            System.out.println("deleted file " + file.name + " successfully");
        }else System.out.println("couldn't delete file " + file);
        }else System.out.println("Cant delete file. filepath is null.");

    }
}
