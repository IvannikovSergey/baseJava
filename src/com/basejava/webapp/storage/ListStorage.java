package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> list = new ArrayList<>();

    @Override
    public void updateAbstr(Resume resume, int index) {
        list.set(index, resume);
        System.out.println("Резюме обновлено " + resume.getUuid());
    }

    @Override
    public void saveAbstr(Resume resume, int index) {
        list.add(resume);
        System.out.println("Резюме добавлено " + resume.getUuid());
    }

    @Override
    protected Resume getAbstr(int index) {
        return list.get(index);
    }

    @Override
    public void deleteAbstr(int index) {
        list.remove(index);
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[list.size()];
        return list.toArray(resumes);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
        System.out.println("Хранилище очищено");
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isIndexExist(int index) {
        return index >= 0;
    }
}
