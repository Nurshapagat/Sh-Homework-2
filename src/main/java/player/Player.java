package org.example.controller.player;

import org.example.controller.room.Room;
import org.example.controller.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private final List<Item> inventory;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return new ArrayList<>(inventory);
    }

    @Override
    public String toString() {
        return "Player is in " + currentRoom.getName();
    }
}
