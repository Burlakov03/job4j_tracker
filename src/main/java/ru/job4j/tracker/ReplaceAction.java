package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter id request for replace: ");
        String name = input.askStr("Enter name request: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Request changed successfully.");
        } else {
            out.println("Request replacement error.");
        }
        return true;
    }
}
