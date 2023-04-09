package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

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
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "name_1");
        return Arrays.binarySearch(storage, 0, countResume, searchKey, RESUME_COMPARATOR);
    }
}
