package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResume;

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("ERROR обновления");
        } else {
            storage[index] = resume;
            System.out.println("Резюме " + resume + " обновлено");
        }
    }

    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResume >= STORAGE_LIMIT) {
            System.out.println("Хранилище полное");
        } else if (index >= 0) {
            System.out.println("Резюме " + resume + " уже существует");
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
        System.out.println("ERROR удаления");
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
            System.out.println("ERROR резюме не найдено");
            return null;
        }
        System.out.println("Резюме " + storage[index] + " найдено");
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void deleteElement(int index);
}
