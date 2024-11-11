# Sports-Booking
Microservice for managing sports reservation schedules, providing efficient handling of sports grounds, groups, coaches, and reservations. This service allows users to create, retrieve, manage, and search for sports reservations based on various criteria.

## Technologies

- Spring Boot
- JPA/Hibernate for data persistence
- REST API for external interactions

## DataBase
- MySQL

## Functionalities

This microservice provides several functionalities for managing sports reservations:

### 1. **Data Entry:**
- **Add a new sports ground** with its details (label, type, capacity, indoor/outdoor).
- **Add a new sports group** (label, sport type, max number of members, competition or recreational).
- **Add a new coach** (name, surname, title, specialty).
- **Add a new reservation slot** with all required details: sports ground, coach, group, start time, end time, day of the week, and type of event (training, competition, free time).

### 2. **Data Retrieval:**
- Retrieve a **sports ground** by label.
- Retrieve **sports groups** by sport type.
- Retrieve **coaches** by name and surname.
- Retrieve **reservation slots** for a specific ground, group, or coach.

### 3. **Manage Reservations:**
- **Add a new reservation slot** to the schedule (sports ground, coach, group, start time, end time, and day of the week).
- **Delete a reservation slot** by providing the start time, ground, and day of the week.

### 4. **Retrieve All Reservations:**
- Retrieve all reservation slots, sorted by:
  - Ground (ascending/descending order).
  - Day of the week and start time (ascending/descending).
  - Type of reservation (training, competition, free time).

### 5. **Schedule Search:**
- Retrieve all reservations for a specific day and ground.
- Retrieve all reservations for a specific sports group.
- Retrieve all reservations for a specific coach.
- Retrieve all reservations for a specific type of sports group (recreational or competitive).
- Retrieve all reservations for a specific type of event (training, competition, free time).

### 6. **Special Functionalities:**
- **Availability check:** Before adding a new reservation, the system checks if the ground and coach are available for the requested time. If the ground or coach is already booked, the reservation cannot be created.
- **Coach and group relation:** Each coach can be linked to multiple groups but must be unique to a reservation slot (only one coach per reservation).
