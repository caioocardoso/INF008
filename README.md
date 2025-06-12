# Academic Event Management System

This is a Java-based command-line application for managing academic events at a university. The system is designed to handle different types of events and participants, applying key Object-Oriented Programming (OOP) concepts as required by the INF008 - Object Oriented Programming course assignment.

## Features

- **Event Management**: Register various types of academic events, such as Lectures, Workshops, Courses, and Fairs.
- **Participant Registration**: Register different categories of participants, including Students, Teachers, and External members, each with their own specific data.
- **Enrollment System**: Enroll participants in events with automatic validation for available slots.
- **Hybrid Event Support**: Handle both online and in-person events, capturing a web link for online events or a physical location for in-person ones.
- **Custom Enrollment Rules**: Enforce specific rules, such as allowing only students to enroll in Courses.
- **Reporting**: Generate reports of all registered events, which can be listed by registration order or grouped by type and data.
- **Certificate Generation**: Create and save a PDF certificate for a participant who has completed an event.

## Technologies Used

- **Language**: Java
- **Build Tool**: Apache Maven
- **External Library**: [iTextPDF](https://itextpdf.com/) for PDF certificate generation.

## Prerequisites

To compile and run this project, you will need the following installed on your machine:

- Java Development Kit (JDK) 8 or higher.
- Apache Maven.

## Compilation and Execution

**1. Compile the Project**

Navigate to the project's root directory and run the following command to compile the source code and package it into a `.jar` file:

```bash
mvn package
```

**2. Run the Application**

After a successful compilation, run the application using the `exec-maven-plugin` with the following command:

```bash
mvn exec:java
```

This will start the application and display the main menu in the console.

## Project Structure

The project's source code is organized into logical packages to ensure a clear separation of concerns:

- `com.INF008.app`: Contains the main application class (`University.java`) and the command-line user interface (`Menu.java`).
- `com.INF008.app.events`: Includes the base `Event` class, its subclasses (`Lecture`, `Course`, `Workshop`, `AcademicFair`), and the `iEvent` interface.
- `com.INF008.app.participants`: Includes the base `Participant` class, its subclasses (`Student`, `Teacher`, `External`), and the `iParticipant` interface.
- `com.INF008.app.services`: Contains the business logic handlers `EventManager` and `ParticipantManager`.
- `com.INF008.app.utils`: Contains utility classes for console colors and other helper functions.