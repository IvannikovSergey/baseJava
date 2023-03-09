package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void update(Resume resume) {
        index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Резюме " + resume + " обновлено");
            return;
        }
        System.out.println("ERROR обновления");
    }

    public void save(Resume resume) {
        index = getIndex(resume.getUuid());
        if (countResume >= STORAGE_LIMIT) {
            System.out.println("Хранилище полное");
        } else if (index != -1) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            storage[countResume] = resume;
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

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

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
