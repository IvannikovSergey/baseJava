package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    private final String UUID_NOT_EXIST = "dummy";
    protected final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final Resume resume1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume resume2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume resume3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume resume4 = new Resume(UUID_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    void update() {
        Resume resume5 = new Resume(UUID_1);
        storage.update(resume5);
        assertSame(resume5, storage.get(UUID_1));
    }

    @Test
    void updateNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    @Test
    void save() {
        storage.save(resume4);
        assertGet(resume4);
        assertSize(4);
    }

    @Test
    void saveExist() throws ExistStorageException {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(resume3);
        }, "ExistStorageException expected!!!");
    }

    @Test
    void get() {
        assertGet(resume1);
        assertGet(resume2);
        assertGet(resume3);
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test
    void deleteNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    @Test
    void getAll() {
        Resume[] actual = storage.getAll();
        Resume[] expected = {resume1, resume2, resume3};
        assertEquals(3, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void getNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get(UUID_NOT_EXIST);
        }, "NotExistStorageException expected!!!");
    }

    void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}