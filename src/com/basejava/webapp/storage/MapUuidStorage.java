package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    protected final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, String uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected void doSave(Resume resume, String uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    public void clear() {
        map.clear();
        System.out.println("Хранилище очищено");
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(map.values());

    }

    @Override
    public int size() {
        return map.size();
    }

}
