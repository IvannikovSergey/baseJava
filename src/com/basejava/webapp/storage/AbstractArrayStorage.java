package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    public int size() {
        return countResume;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            System.out.println("Резюме " + storage[index] + " найдено");
            return storage[index];
        }
        System.out.println("ERROR резюме не найдено");
        return null;
    }

    protected abstract int getIndex(String uuid);
}
