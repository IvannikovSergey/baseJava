package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    protected final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
        System.out.println("Резюме " + uuid + " обновлено");
    }

    @Override
    protected void doSave(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
        System.out.println("Резюме добавлено " + resume.getUuid());
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove(uuid);
        System.out.println("Резюме " + uuid + " удалено");
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey(uuid);
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
