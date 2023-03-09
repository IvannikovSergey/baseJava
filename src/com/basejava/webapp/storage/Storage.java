package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public interface Storage {

    public void clear();

    public void update(Resume resume);

    public void save(Resume resume);

    public Resume get(String uuid);

    public void delete(String uuid);

    public Resume[] getAll();

    public int size();
}
