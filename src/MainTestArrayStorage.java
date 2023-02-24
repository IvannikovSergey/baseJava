/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume();
        resume1.uuid = "uuid1";
        Resume resume2 = new Resume();
        resume2.uuid = "uuid2";
        Resume resume3 = new Resume();
        resume3.uuid = "uuid3";

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        System.out.println(ARRAY_STORAGE.size());

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resume1.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(resume1.uuid);
        printAll();
        ARRAY_STORAGE.clear();
        System.out.println(ARRAY_STORAGE.size());
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
    }
}
