# Makerspace Concurrency Simulator

Simulates a **shared makerspace** where multiple production tasks (knickknacks) run concurrently while safely sharing limited tools and stations. Demonstrates **threads, locks, and concurrency management** in Java.

## Knickknacks

- Figurines  
- Motor Controllers  
- Chess Set  
- Toaster Pastry  
- Cup Holder  
- SAK Scales  
- Flashlight  

## Stations (Shared Resources)

FDM Printer, Resin Printer, Soldering Iron, Toaster Oven, Lathe, Mill, Airbrush

## Features

- Multi-threaded production of knickknacks  
- Safe access to shared stations using `ReentrantLock`  
- Real-time progress reporting  
- Configurable quantities and reporting intervals  
- Includes a simple concurrency demo (`SimpleTask.java`)

## Techniques & Concepts

- Thread synchronization  
- Resource management and deadlock prevention  
- Concurrent programming in Java

## Running the Program

Run `Main.java`. You’ll be prompted to enter:

- Quantity for each knickknack (`0` to skip)  
- Progress report interval (every X items)

## Technologies Used

- Java (JDK 11+)  
- IntelliJ IDEA

## Project Context

Developed as part of **COSC 2P13 – Concurrent Programming** at Brock University.
