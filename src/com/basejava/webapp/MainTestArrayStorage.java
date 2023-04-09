package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ArrayStorage;
import com.basejava.webapp.storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("uuid1");
        Resume resume4 = new Resume("uuid4");
        Resume resume3 = new Resume("uuid3");
        Resume resume2 = new Resume("uuid2");



        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume4);
        ARRAY_STORAGE.save(resume3);
        ARRAY_STORAGE.save(resume2);
        printAll();

        System.out.println(ARRAY_STORAGE.get("uuid3"));

        System.out.println(ARRAY_STORAGE.size());
        printAll();

        System.out.println("Get r1: " + ARRAY_STORAGE.get("uuid2"));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();

        ARRAY_STORAGE.delete("uuid4");
        printAll();

        ARRAY_STORAGE.clear();
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(resume);
        }
    }
}
