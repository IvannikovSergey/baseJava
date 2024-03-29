package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        storage[countResume] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        if (index != -1) {
            storage[index] = storage[countResume - 1];
        }
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
