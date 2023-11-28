package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter id request for delete: ");
        if (tracker.delete(id)) {
            out.println("Request deleted successfully.");
        } else {
            out.println("Request deletion error.");
        }
        return true;
    }
}
