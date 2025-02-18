MUD Controller

Overview

This project is a simple MUD Controller, designed to handle player commands and interactions within a text-based dungeon environment. The game allows players to explore rooms, pick up items, and navigate the dungeon using simple commands.

🎯 Features:
Command Parsing: Reads user input, identifies the main command, and extracts arguments.

Room Navigation: Allows the player to move forward, back, left, and right if a room exists in that direction.

Item Interaction: Enables the player to pick up items from the room and add them to their inventory.

Game Loop: Runs a continuous loop to process player commands until they choose to exit.

Help & Exit Commands: Displays available commands and allows users to quit the game.

Error Handling: Provides appropriate messages for invalid commands or unavailable actions.


Available Commands:

look – Describe the current room.
move <forward|back|left|right> – Move in a specified direction.
pick up <itemName> – Pick up an item from the room.
inventory – Show the player's inventory.
help – Display a list of available commands.
quit or exit – End the game.

📂 Project Structure:

Sh-Homework-2
│── src/main/java/org/example
│   ├── controller
│   │   ├── MUDController.java
│   │   ├── Main.java
│   ├── player
│   │   ├── Player.java
│   ├── room
│   │   ├── Room.java
│   ├── item
│   │   ├── Item.java
│── pom.xml
│── README.md
