package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    protected final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, Object r) {
        map.put(resume.getUuid(), resume);
        System.out.println("Резюме " + resume.getUuid() + " обновлено");
    }

    @Override
    protected void doSave(Resume resume, Object r) {
        map.put(resume.getUuid(), resume);
        System.out.println("Резюме добавлено " + resume.getUuid());
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getUuid());
        System.out.println("Резюме " + ((Resume) resume).getUuid() +" удалено");
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    public void clear() {
        map.clear();
        System.out.println("Хранилище очищено");
    }

    @Override
    public List<Resume> getAllSorted() {
        ArrayList<Resume> list = new ArrayList<>(map.values());
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        return list;

    }

    @Override
    public int size() {
        return map.size();
    }

}
