# Simple Tic-Tac Toe Game with Java Swing, Login, and Statistics



## Student Information

Name: Mohammad Daffa Balthazar Rusbini

Student ID: 5026251106

Class: A



## Project Description

This project is a simple Tic-Tac Toe game built using Java Swing. The application includes login, game statistics, and Top 5 scorer feature.



## Features

- Login using database

- Play Tic-Tac Toe using Swing GUI

- Record wins, losses, draws, and score

- Display personal statistics

- Display Top 5 scorers using JTable



## Database

Database used: MySQL



## How to Run

1. Create the database `game_project`.

2. Import `schema.sql`.

3. Open the Java project.

4. Add JDBC driver (`mysql-connector-j.jar`).

5. Configure `DatabaseManager.java`.

6. Run `Main.java`.



## Class Explanation

Main: Starts the program and opens the Login Window.

DatabaseManager: Handles JDBC database connection.

Player: Stores player data such as id, username, wins, losses, draws, and score.

PlayerService: Handles login, retrieving player data, updating statistics, and retrieving Top 5 scorers.

GameLogic: Handles move validation, winner checking, draw checking, and computer moves.

LoginFrame: Swing window for username and password input.

MainMenuFrame: Swing window for the main menu after login.

GameFrame: Swing window for playing the game.

StatisticsFrame: Swing window for showing personal statistics.

TopScorersFrame: Swing window for showing Top 5 scorers using a table.



## Screenshots





## Links

YouTube:

