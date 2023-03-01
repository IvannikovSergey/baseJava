package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume();
        resume1.setUuid("uuid1");
        Resume resume2 = new Resume();
        resume2.setUuid("uuid2");
        Resume resume3 = new Resume();
        resume3.setUuid("uuid3");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        System.out.println(ARRAY_STORAGE.size());
        printAll();
        resume1.setUuid("uuid56");
        ARRAY_STORAGE.update(resume1);

        printAll();
        System.out.println("Get r1: " + ARRAY_STORAGE.get("uuid2"));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete("uuid56");
        printAll();
        ARRAY_STORAGE.clear();
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
