package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> list = new ArrayList<>();

    @Override
    public void doUpdate(Resume resume, Object index) {
        list.set((Integer) index, resume);
        System.out.println("Резюме обновлено " + resume.getUuid());
    }

    @Override
    public void doSave(Resume resume, Object index) {
        list.add(resume);
        System.out.println("Резюме добавлено " + resume.getUuid());
    }

    @Override
    protected Resume doGet(Object index) {
        return list.get((Integer) index);
    }

    @Override
    public void doDelete(Object index) {
        list.remove(((Integer) index).intValue());
        System.out.println("Резюме удалено");
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
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer)index >= 0;
    }
}
