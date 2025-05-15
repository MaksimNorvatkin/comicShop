package org.comic;

public class Main {

    public static void main(String[] args) {
        ItemController controller = ControllerFactory.createController();
        ConsoleUI consoleUI = new ConsoleUI(controller);
        consoleUI.run();
    }
}