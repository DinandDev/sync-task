# SyncTask 

A real-time, collaborative task management system built in Java. This project demonstrates clean architecture, multi-user synchronization, and professional software development practices.

## Overview
SyncTask was developed to explore the complexities of distributed systems and GUI design. Unlike a standard "To-Do" list, this application focuses on real-time data persistence and multi-client synchronization.

### Key Features
- **Real-time Sync:** Collaborative task updates using Java Sockets.
- **Persistence:** Data storage using JSON (Jackson).
- **Modern UI:** Responsive interface built with JavaFX and SceneBuilder.
- **Robust Logic:** Fully unit-tested core using JUnit 5.
  
## Tech Stack
- **Language:** Java 21
- **Build Tool:** Maven
- **UI Framework:** JavaFX
- **Testing:** JUnit 5 / Mockito
- **Data:** Jackson (JSON)

## Architecture
The project follows a strict **Model-View-Controller (MVC)** pattern to ensure a clear separation of concerns:
- **Model:** Represents the data (Tasks, Users).
- **Service/Logic:** Handles task manipulation and file I/O.
- **View/Controller:** Manages the JavaFX stage and user interactions.


## Getting Started

### Prerequisites
- JDK 21 or higher
- Maven 3.9+

### Installation
1. Clone the repository:
   ```Bash
   git clone [https://github.com/DinandDev/sync-task.git](https://github.com/DinandDev/sync-task.git)
   ```
    Navigate to the directory:
    ```Bash
    cd sync-task
    ```
    Build the project:
    ```Bash
    mvn clean install
    ```
   
Testing

To run the automated test suite, use the following command:

```Bash
mvn test
```
