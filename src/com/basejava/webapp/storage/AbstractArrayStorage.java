package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    @Override
    public final void updateAbstr(Resume resume, int index) {
        storage[index] = resume;
        System.out.println("Резюме " + resume + " обновлено");
    }

    @Override
    public final void saveAbstr(Resume resume, int index) {
        if (countResume == STORAGE_LIMIT) {
            throw new StorageException("Хранилище полное", resume.getUuid());
        } else {
            insertElement(resume, index);
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

    @Override
    public final Resume getAbstr(int index) {
        System.out.println("Резюме " + storage[index] + " найдено");
        return storage[index];
    }

    @Override
    public final void deleteAbstr(int index) {
        deleteElement(index);
        storage[countResume - 1] = null;
        countResume--;
        System.out.println("Резюме удалено");
    }

    @Override
    protected boolean isIndexExist(int index) {
        return index >= 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
        System.out.println("Хранилище очищено");
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);
}
