package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
        System.out.println("Хранилище очищено");
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
            System.out.println("Резюме " + resume + " обновлено");
        }
    }

    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResume == STORAGE_LIMIT) {
            throw new StorageException("Хранилище полное", resume.getUuid());
        } else if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            insertElement(resume, index);
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            deleteElement(index);
            storage[countResume - 1] = null;
            countResume--;
            System.out.println("Резюме удалено");
            return;
        }
        throw new NotExistStorageException(uuid);
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    public int size() {
        return countResume;
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        System.out.println("Резюме " + storage[index] + " найдено");
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);
}
