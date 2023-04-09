package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    private final String UUID_NOT_EXIST = "dummy";
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final Resume resume1 = new Resume(UUID_1, "name_1");
    private static final String UUID_2 = "uuid2";
    private static final Resume resume2 = new Resume(UUID_2, "name_2");
    private static final String UUID_3 = "uuid3";
    private static final Resume resume3 = new Resume(UUID_3, "name_3");
    private static final String UUID_4 = "uuid4";
    private static final Resume resume4 = new Resume(UUID_4, "name_4");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void update() {
        Resume resume5 = new Resume(UUID_1, "name_5");
        storage.update(resume5);
        assertSame(resume5, storage.get(UUID_1));
    }

    @Test
    public void updateNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    @Test
    public void save() {
        storage.save(resume4);
        assertGet(resume4);
        assertSize(4);
    }

    @Test
    public void saveExist() throws ExistStorageException {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(resume3);
        }, "ExistStorageException expected!!!");
    }

    @Test
    public void get() {
        assertGet(resume1);
        assertGet(resume2);
        assertGet(resume3);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
//        storage.get(UUID_1);
    }

    @Test
    public void deleteNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    @Test
    public void getAll() {
        List<Resume> actual = storage.getAllSorted();
        List<Resume> expected = new ArrayList<>();
        expected.add(resume1);
        expected.add(resume2);
        expected.add(resume3);
        assertEquals(3, actual.size());
        assertArrayEquals(List.of(expected).toArray(), List.of(actual).toArray());
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void getNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}