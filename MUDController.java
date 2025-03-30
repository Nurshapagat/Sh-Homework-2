package org.example.controller;

import java.util.Scanner;
import org.example.controller.room.Room;
import org.example.controller.player.Player;
import org.example.controller.item.Item;

public class MUDController {
    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the MUD game! Type 'help' for a list of commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Invalid command. Use 'pick up <item>'.");
                }
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("Room: " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());

        if (!currentRoom.getItems().isEmpty()) {
            System.out.print("Items here: ");
            for (Item item : currentRoom.getItems()) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No items here.");
        }
    }

    private void move(String direction) {
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getConnectedRoom(direction);

        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved to: " + nextRoom.getName());
            lookAround();
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItemByName(itemName);

        if (item != null) {
            currentRoom.removeItem(item);
            player.addItem(item);
            System.out.println("You picked up the " + itemName + ".");
        } else {
            System.out.println("No item named " + itemName + " here!");
        }
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : player.getInventory()) {
                System.out.println("- " + item.getName());
            }
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describe the current room.");
        System.out.println("move <forward|back|left|right> - Move in a specified direction.");
        System.out.println("pick up <itemName> - Pick up an item.");
        System.out.println("inventory - List the items you are carrying.");
        System.out.println("help - Show this menu.");
        System.out.println("quit or exit - End the game.");
    }
}
