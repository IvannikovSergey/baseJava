package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    @Override
    public final void doUpdate(Resume resume, Object index) {
        storage[(int) index] = resume;
        System.out.println("Резюме " + resume + " обновлено");
    }

    @Override
    public final void doSave(Resume resume, Object index) {
        if (countResume == STORAGE_LIMIT) {
            throw new StorageException("Хранилище полное", resume.getUuid());
        } else {
            insertElement(resume, (Integer) index);
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

    @Override
    public final Resume doGet(Object index) {
        System.out.println("Резюме " + storage[(int) index] + " найдено");
        return storage[(int) index];
    }

    @Override
    public final void doDelete(Object index) {
        deleteElement((Integer) index);
        storage[countResume - 1] = null;
        countResume--;
        System.out.println("Резюме удалено");
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer)index >= 0;
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
