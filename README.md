# 🎮 Tic-Tac-Toe

https://github.com/user-attachments/assets/ab1fab1b-c41f-4402-ba69-cb375bdbe9bd

> 🎥 Tic-Tac-Toe Gameplay Demonstration!

---

## Table of Contents

- [Introduction](#introduction)
- [Architecture Diagram](#architecture-diagram)
- [Design Patterns](#design-patterns)
- [Project Structure](#project-structure)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Application Workflow](#application-workflow)
- [Screenshots](#screenshots)
- [Future Enhancements](#future-enhancements)
- [Resources](#resources)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Introduction

**Tic-Tac-Toe** is a console-based Java application developed using **Object-Oriented Programming (OOP)** principles and **Low-Level Design (LLD)** concepts.

The project demonstrates clean software architecture through the implementation of multiple design patterns, modular components, and extensible gameplay logic. It supports **Human vs Human** and **Human vs Bot** gameplay with configurable bot difficulty levels, dynamic board sizes, replay support, and a live scoreboard.

The primary goal of this project is to showcase backend engineering practices, object-oriented design, and maintainable software architecture rather than graphical user interface development.

---

## Architecture Diagram

<img width="570" height="595" alt="Architecture drawio" src="https://github.com/user-attachments/assets/fc2b9e55-58bf-409d-9c4e-2e85b95f64ef" />

The application follows a modular architecture that separates responsibilities between the presentation layer, controller, domain models, factories, and strategy implementations, making the codebase easier to extend and maintain.

---

## Design Patterns

This project demonstrates several widely used software design patterns.

| Design Pattern | Purpose |
|----------------|---------|
| **Builder Pattern** | Simplifies game creation while validating required game configuration. |
| **Factory Pattern** | Creates appropriate bot-playing and game-winning strategy implementations. |
| **Strategy Pattern** | Allows interchangeable bot-playing algorithms and winning strategies. |
| **MVC (Lightweight)** | Separates console interaction, controller logic, and domain models. |
| **SOLID Principles** | Encourages modular, maintainable, and extensible software design. |

---

## Project Structure

```text
Game_tic-tac-toe/
│
├── .github/
│
├── src/
│   ├── controllers/
│   │   └── GameController.java
│   │
│   ├── exceptions/
│   │   └── InvalidGameConstructionParametersException.java
│   │
│   ├── factories/
│   │   ├── BotPlayingStrategyFactory.java
│   │   └── GameWinningStrategyFactory.java
│   │
│   ├── models/
│   │   ├── Board.java
│   │   ├── Bot.java
│   │   ├── BotDifficultyLevel.java
│   │   ├── Cell.java
│   │   ├── CellState.java
│   │   ├── Game.java
│   │   ├── GameState.java
│   │   ├── Move.java
│   │   ├── Player.java
│   │   ├── PlayerType.java
│   │   ├── ScoreBoard.java
│   │   └── WinningStrategyType.java
│   │
│   ├── strategies/
│   │   ├── botplayingstrategy/
│   │   │   ├── BotPlayingStrategy.java
│   │   │   └── RandomBotPlayingStrategy.java
│   │   │
│   │   └── gamewinningstrategy/
│   │       ├── GameWinningStrategy.java
│   │       └── OrderOneGameWinningStrategy.java
│   │
│   └── TicTacToeMain.java
│
├── .gitignore
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── LICENSE
└── README.md
```

---

## Features

- Human vs Human gameplay
- Human vs Bot gameplay
- Multiple Bot Difficulty Levels
  - Easy
  - Medium
  - Hard
- Dynamic board size (3×3 and above)
- Live Scoreboard across multiple games
- Play Again functionality
- Duplicate player name validation
- Duplicate symbol validation
- Comprehensive input validation
- Invalid move handling
- Automatic winner detection
- Draw detection
- Clean console board rendering
- Extensible architecture using design patterns

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Object-Oriented Programming (OOP) | Software Design |
| Low-Level Design (LLD) | System Design |
| Design Patterns | Extensible Architecture |
| Git | Version Control |
| GitHub | Source Code Hosting |
| IntelliJ IDEA | Integrated Development Environment |

---

## Application Workflow

1️⃣ Launch the application.

2️⃣ Enter the board dimension.

3️⃣ Choose the game mode (Human vs Human or Human vs Bot).

4️⃣ Enter player details and assign unique symbols.

5️⃣ Select the bot difficulty level (if playing against a bot).

6️⃣ Players take turns making valid moves.

7️⃣ The game automatically validates each move and checks for:
   - Winner
   - Draw
   - Invalid moves

8️⃣ Display the game result and the final board.

9️⃣ Update the live scoreboard.

🔟 Choose whether to play another game or exit the application.

---

## Screenshots

<img width="1366" height="733" alt="SS1" src="https://github.com/user-attachments/assets/8231ef05-9225-4293-9be7-44a99bdcf8ec" />
<img width="1364" height="731" alt="SS2" src="https://github.com/user-attachments/assets/6173823d-79a4-44a0-ba0b-17ded42f02ca" />
<img width="1366" height="734" alt="SS3" src="https://github.com/user-attachments/assets/38708c07-0bee-4a85-9c67-e07abd14d748" />
<img width="1366" height="732" alt="SS4" src="https://github.com/user-attachments/assets/26f4af6d-c22f-40b7-ba41-eb46d671dd82" />
<img width="1365" height="731" alt="SS5" src="https://github.com/user-attachments/assets/6152c3c1-7472-4feb-b793-d25a1503dc1f" />
<img width="1366" height="734" alt="SS6" src="https://github.com/user-attachments/assets/7d51645f-ae69-45b8-82fa-d43399bebc51" />
<img width="1366" height="735" alt="SS7" src="https://github.com/user-attachments/assets/efceb211-54a3-4c33-b70e-e2ae3759aa7f" />
<img width="1366" height="735" alt="SS8" src="https://github.com/user-attachments/assets/1f05633e-00aa-4b83-97a0-b175d5475582" />

---

## Future Enhancements

- Minimax-based AI Bot
- Java Swing / JavaFX GUI
- Save & Resume Games
- Persistent Scoreboard
- Comprehensive JUnit Test Suite
- Docker Support
- Game Analytics

---

## Resources

[![W3Schools | Java Tutorial](https://img.shields.io/badge/W3Schools-Java%20Tutorial-04AA6D?style=for-the-badge&logo=w3schools&logoColor=white)](https://www.w3schools.com/java/default.asp)
[![GeeksforGeeks | OOP in Java](https://img.shields.io/badge/GeeksforGeeks-OOP%20in%20Java-2F8D46?style=for-the-badge&logo=geeksforgeeks&logoColor=white)](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
[![GeeksforGeeks | Low-Level Design (LLD)](https://img.shields.io/badge/GeeksforGeeks-Low--Level%20Design%20(LLD)-2F8D46?style=for-the-badge&logo=geeksforgeeks&logoColor=white)](https://www.geeksforgeeks.org/system-design/what-is-low-level-design-or-lld-learn-system-design/)

---

## Contributing

Contributions are welcome. Before submitting changes, please review:

- [Contributing Guide](./Contributing.md)
- [Code of Conduct](./CODE_OF_CONDUCT.md)
- [Security Policy](./.github/SECURITY.md)

---

## License

This project is licensed under the **MIT License**.

See the **[LICENSE](./LICENSE)** file for details.

---

## Author

[**Sahil Sharma**](https://github.com/sahil-me)

Thank you for exploring this project.

If you found this project helpful, consider giving it a ⭐ to support its continued development.

