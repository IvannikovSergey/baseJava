package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final Resume resume1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume resume2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume resume3 = new Resume(UUID_3);

    protected AbstractArrayStorageTest(Storage storage) {
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
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void update() {
        Resume resume5 = new Resume(UUID_1);
        storage.update(resume5);
        assertSame(resume5, storage.get(UUID_1));
    }

    @Test
    void updateIfNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("dymmmy");
        }, "NotExistStorageException expected!!!");
    }

    @Test
    void save() {
        Resume resume4 = new Resume("uuid4");
        storage.save(resume4);
        assertGet(resume4);
        assertSize(4);
    }

    @Test
    void saveIfExist() throws ExistStorageException {
        assertThrows(ExistStorageException.class, () -> {
            storage.save(resume3);
        }, "ExistStorageException expected!!!");
    }

    @Test
    void saveOverFlow() throws StorageException {
        storage.clear();
        try {
            for (int i = 1; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                System.out.println(i);
                storage.save(new Resume());
            }
        } catch (StorageException ex) {
            Assertions.fail("Переполнение раньше времени");
        }
        storage.save(new Resume());
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test
    void deleteIfNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete("dymmmy");
        }, "NotExistStorageException expected!!!");
    }

    @Test
    void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length);
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void get() {
        assertGet(resume1);
        assertGet(resume2);
        assertGet(resume3);
    }

    @Test
    void getIfNotExist() throws NotExistStorageException {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("dymmmy");
        }, "NotExistStorageException expected!!!");
    }

    void assertSize(int size) {
        assertEquals(size, storage.size());
    }

    void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}