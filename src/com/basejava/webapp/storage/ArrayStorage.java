package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResume;
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
        if (countResume >= storage.length) {
            System.out.println("Хранилище полное");
        } else if (index != -1) {
            System.out.println("Резюме " + resume + " уже существует");
        } else {
            storage[countResume] = resume;
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

    public Resume get(String uuid) {
        index = getIndex(uuid);
        if (index != -1) {
            System.out.println("Резюме " + storage[index] + " найдено");
            return storage[index];
        }
        System.out.println("ERROR резюме не найдено");
        return null;
    }

    public void delete(String uuid) {
        index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[countResume - 1];
            storage[countResume - 1] = null;
            countResume--;
            System.out.println("Резюме " + storage[index] + " удалено");
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

    public int size() {
        return countResume;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
