package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    private int index;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    @Override
    public void update(Resume resume) {
        index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Резюме " + resume + " обновлено");
            return;
        }
        System.out.println("ERROR обновления");
    }

    @Override
    public void save(Resume resume) {
        index = Arrays.binarySearch(storage, 0, countResume, resume);
        if (index < 0) {
            index = -index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, countResume - index);
        storage[index] = resume;
        countResume++;
    }

    @Override
    public void delete(String uuid) {
        index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[countResume - 1];
            storage[countResume - 1] = null;
            countResume--;
            System.out.println("Резюме удалено");
            return;
        }
        System.out.println("ERROR удаления");
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, countResume, searchKey);
    }
}
