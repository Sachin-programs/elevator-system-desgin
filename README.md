Elevator desgin — LLD Practice
A Low-Level Design implementation of a Elevator system in Java.

Design Patterns:

State Pattern — Elevator behaves differently based on its current state (IDLE, MOVING_UP, MOVING_DOWN, DOORS_OPEN). Each state determines what happens when move() is called.
Strategy Pattern — not used here but will come in BookMyShow (seat pricing)

Algorithm:

SCAN Algorithm (Elevator Algorithm) — Elevator moves in one direction, serves all requests along the way, then reverses. Same as how a hard disk read head works.

Class Structure:
Building
  - List<Floor> floors
  - List<Elevator> elevators

Elevator
  - int currentFloor
  - ElevatorState state (enum: IDLE, MOVING_UP, MOVING_DOWN, DOORS_OPEN)
  - PriorityQueue<Integer> upRequests (min-heap)
  - PriorityQueue<Integer> downRequests (max-heap)

Floor
  - int floorNumber
  - boolean upButtonPressed
  - boolean downButtonPressed

ExternalRequest
  - int floor
  - Direction direction (enum: UP, DOWN)

InternalRequest
  - int floor

Direction (enum) → UP, DOWN
ElevatorState (enum) → IDLE, MOVING_UP, MOVING_DOWN, DOORS_OPEN

Key Concepts
Priority Queue min-heap for UP requests — serves lowest floor above you first
Priority Queue max-heap for DOWN requests — serves highest floor below you first

How to Run
Clone the repo
Open in IntelliJ or any Java IDE
Run App.java
Part of
My LLD interview prep series — solving one problem per day.
