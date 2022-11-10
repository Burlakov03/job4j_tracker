package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Create request " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The repository does not contain requests.");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ===");
                int id = input.askInt("Enter id request for replace: ");
                String name = input.askStr("Enter name request: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Request changed successfully.");
                } else {
                    System.out.println("Request replacement error.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                int id = input.askInt("Enter id request for delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Request deleted successfully.");
                } else {
                    System.out.println("Request deletion error.");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id===");
                int id = input.askInt("Enter id search item by id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("The request with the entered id: " + id + " was not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name===");
                String name = input.askStr("Enter name search item by name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The request with the entered name: " + name + " was not found.");
                }
            } else if (select != 6) {
                System.out.println("User  selected: " + select);
            } else {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
