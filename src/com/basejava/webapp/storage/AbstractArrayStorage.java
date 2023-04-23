package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    @Override
    public final void doUpdate(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    public final void doSave(Resume resume, Integer index) {
        if (countResume == STORAGE_LIMIT) {
            throw new StorageException("Хранилище полное", resume.getUuid());
        } else {
            insertElement(resume, index);
            countResume++;
        }
    }

    @Override
    public final Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    public final void doDelete(Integer index) {
        deleteElement(index);
        storage[countResume - 1] = null;
        countResume--;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    public List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size()));
    }

    public int size() {
        return countResume;
    }

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);
}
