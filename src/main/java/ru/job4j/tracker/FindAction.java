package ru.job4j.tracker;

public class FindAction implements UserAction {
    @Override
    public String name() {
        return "Find item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("===Find item by id===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введеным id: " + id + " не найдена");
        }
        return true;
    }
}
