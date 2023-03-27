package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void updateAbstr(Resume resume, int index);

    protected abstract void saveAbstr(Resume resume, int index);

    protected abstract Resume getAbstr(int index);

    protected abstract void deleteAbstr(int index);

    protected abstract int getIndex(String uuid);

    protected abstract boolean isIndexExist(int index);

    public void update(Resume resume) {
        int index = getExistIndex(resume.getUuid());
        updateAbstr(resume, index);
    }

    public void save(Resume resume) {
        int index = getNotExistIndex(resume.getUuid());
        saveAbstr(resume, index);
    }

    public Resume get(String uuid) {
        int index = getExistIndex(uuid);
        return getAbstr(index);
    }

    public void delete(String uuid) {
        int index = getExistIndex(uuid);
        deleteAbstr(index);

    }

    private int getExistIndex(String uuid) {
        int index = getIndex(uuid);
        if (!isIndexExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private int getNotExistIndex(String uuid) {
        int index = getIndex(uuid);
        if (isIndexExist(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}
