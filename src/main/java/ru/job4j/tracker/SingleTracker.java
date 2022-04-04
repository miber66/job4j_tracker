package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker instance = null;

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return SingleTracker.getInstance().add(item);
    }

    public Item[] findAll() {
        return SingleTracker.instance.findAll();
    }

    public Item[] findByName(String key) {
        return SingleTracker.instance.findByName(key);
    }

    public Item findById(int id) {
        return SingleTracker.instance.findById(id);
    }

    public boolean replace(int id, Item item) {
        return SingleTracker.instance.replace(id, item);
    }

    public boolean delete(int id) {
        return SingleTracker.instance.delete(id);
    }
}
