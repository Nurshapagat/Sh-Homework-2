package org.example.controller;

import org.example.controller.player.Player;
import org.example.controller.room.Room;
import org.example.controller.item.Item;
public class Main {
    public static void main(String[] args) {
        Room startRoom = new Room("Start Room", "A dark room with a single torch.");
        Room hallway = new Room("Hallway", "A long corridor with stone walls.");

        startRoom.connectRoom("forward", hallway);
        hallway.connectRoom("back", startRoom);

        Item sword = new Item("sword");
        startRoom.addItem(sword);

        Player player = new Player(startRoom);
        MUDController controller = new MUDController(player);

        controller.runGameLoop();
    }
}
