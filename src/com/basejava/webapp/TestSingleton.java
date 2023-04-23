package com.basejava.webapp;

public class TestSingleton {
    private static TestSingleton ourInstance = new TestSingleton();

    public static TestSingleton getInstance() {
        return ourInstance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        getInstance().toString();
    }
}
