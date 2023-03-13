package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int insIndex = -index - 1;
        System.arraycopy(storage, insIndex, storage, insIndex + 1, countResume - insIndex);
        storage[insIndex] = resume;
    }

    @Override
    protected void deleteElement(int index) {
        if (index != -1) {
            int remainingElements = countResume - (index + 1);
            System.arraycopy(storage, index + 1, storage, index, remainingElements);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, countResume, searchKey);
    }
}
