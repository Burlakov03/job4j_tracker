package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemsByName(input, tracker);
            } else if (select != 6) {
                System.out.println("User  selected: " + select);
            } else {
                run = false;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Create request " + item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The repository does not contain requests.");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ===");
        int id = input.askInt("Enter id request for replace: ");
        String name = input.askStr("Enter name request: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Request changed successfully.");
        } else {
            System.out.println("Request replacement error.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = input.askInt("Enter id request for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Request deleted successfully.");
        } else {
            System.out.println("Request deletion error.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id===");
        int id = input.askInt("Enter id search item by id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The request with the entered id: " + id + " was not found.");
        }

    }

    public static void findItemsByName(Input input, Tracker tracker) {
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
