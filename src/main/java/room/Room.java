package org.example.controller.room;
;
import org.example.controller.item.Item;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final String description;
    private final List<Item> items;
    private final HashMap<String, Room> connections;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.connections = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Item getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public void connectRoom(String direction, Room room) {
        connections.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connections.get(direction);
    }
}
