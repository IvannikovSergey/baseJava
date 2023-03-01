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

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void update(Resume resume) {
        if (isResumeExist(resume)) {
            for (int i = 0; i < countResume; i++) {
                if (resume.uuid.equals(getAll()[i].uuid)) {
                    getAll()[i] = resume;
                    System.out.println("Резюме " + getAll()[i] + " обновлено");
                    return;
                }
            }
        }
        System.out.println("ERROR обновления");
    }

    public void save(Resume resume) {
        if (countResume >= storage.length) {
            System.out.println("Хранилище полное");
        } else if (countResume != 0 && !isResumeExist(resume)) {
            storage[countResume] = resume;
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        } else if (countResume == 0) {
            storage[countResume] = resume;
            countResume++;
            System.out.println("Резюме " + resume + " добавлено");
        }
    }

    public Resume get(String uuid) {
        if (isResumeExist(uuid)) {
            for (int i = 0; i < countResume; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    System.out.println("Резюме " + storage[i].uuid + " найдено");
                    return storage[i];
                }
            }
        }
        System.out.println("ERROR резюме не найдено");
        return null;
    }

    public void delete(String uuid) {
        if (isResumeExist(uuid)) {
            for (int i = 0; i < countResume; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    storage[i] = storage[countResume - 1];
                    storage[countResume - 1] = null;
                    countResume--;
                    System.out.println("Резюме удалено");
                    return;
                }
            }
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

    private boolean isResumeExist(Resume resume) {
        for (int i = 0; i < countResume; i++) {
            if (getAll()[i].uuid.equals(resume.uuid)) {
                return true;
            }
        }
        return false;
    }

    private boolean isResumeExist(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(getAll()[i].uuid)) {
                return true;
            }
        }
        return false;
    }
}
