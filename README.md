# Parking Lot Management System

A **Java-based web application** developed to streamline parking operations by managing vehicle records, slot allocation, entry/exit timestamps, and charges efficiently.

This project is built using **JSP, Servlets, JDBC, and Oracle Database** while following the **MVC (Model-View-Controller)** architecture to ensure clean code structure and scalability.

---

## Features:

* Add new parking records with automatic Record ID generation
* View specific parking details using vehicle number and entry time
* Display all parking records stored in the database
* Prevent duplicate entries
* Strong input validation and exception handling
* Organized layered architecture (Bean → DAO → Service → Servlet)


---

## Tech Stack:

- **Backend:** Java, Servlets, JDBC

- **Frontend:** JSP, HTML

- **Database:** Oracle SQL

- **Server:** Apache Tomcat

- **IDE:** Eclipse

- **Version Control:** Git & GitHub

---

## Project Structure:

```
Parking_Lot_Management_System
│
├── src/main/java/com/wipro/parking
│   ├── bean
│   │     └── ParkingBean.java
│   │
│   ├── dao
│   │     └── ParkingDAO.java
│   │
│   ├── service
│   │     └── Administrator.java
│   │
│   ├── servlets
│   │     └── MainServlet.java
│   │
│   └── util
│         ├── DBUtil.java
│         └── InvalidInputException.java
│
├── src/main/webapp
│      ├── menu.html
│      ├── addParking.jsp
│      ├── viewParking.jsp
│      ├── viewAllParkings.jsp
│      ├── displayParking.jsp
│      ├── displayAllParkings.jsp
│      ├── success.html
│      └── error.html
│
└── Query.txt
```

---

## Architecture:

The application follows the **MVC Design Pattern**:

* **Model:** `ParkingBean` represents parking data.
* **View:** JSP and HTML pages handle user interaction.
* **Controller:** `MainServlet` processes requests and responses.
* **Service Layer:** `Administrator` performs validations and business logic.
* **DAO Layer:** `ParkingDAO` manages database operations.
* **Utility:** `DBUtil` handles database connectivity, and `InvalidInputException` manages custom errors.

---

## Database Schema:

### Table: `PARKING_TB`

| Column Name    | Description         |
| -------------- | ------------------- |
| RECORDID       | Primary Key         |
| VEHICLENUMBER  | Vehicle identifier  |
| SLOTNUMBER     | Parking slot number |
| ENTRY_DATETIME | Entry date & time   |
| EXIT_DATETIME  | Exit date & time    |
| CHARGES        | Parking fee         |
| REMARKS        | Additional notes    |

### Sequence:

```
PARKING_SEQ
START WITH 10
INCREMENT BY 1
MAXVALUE 99
```

---

## How to Run the Project:

### Clone the Repository

```bash
git clone https://github.com/your-username/Parking_Lot_Management_System.git
```

### Import into Eclipse

```
File → Import → Existing Projects into Workspace
```

### Configure Apache Tomcat Server

### Setup Database

* Create the `PARKING_TB` table
* Create the `PARKING_SEQ` sequence
* Update database credentials inside **DBUtil.java**

### Run the Server and Open

```
http://localhost:8080/Parking_Lot_Management_System/menu.html
```

---

## 📸 Application Screenshots:

### Menu Page

The central navigation page that allows users to access all parking operations.

<img width="618" height="328" alt="Screenshot 2026-02-13 123149" src="https://github.com/user-attachments/assets/da570f86-af48-44ba-813d-56491f41f09e" />


---

### Add Parking Record

Users can enter vehicle details, slot number, entry time, and remarks to create a new parking record.

<img width="669" height="390" alt="Screenshot 2026-02-13 123241" src="https://github.com/user-attachments/assets/586be06a-2fe0-4647-a0b6-1f4143c50d37" />


---

### Success Page

Displayed after a parking record is added successfully.

<img width="639" height="251" alt="Screenshot 2026-02-13 123249" src="https://github.com/user-attachments/assets/eacef4de-3639-4706-8ea8-b391d2c9e4d8" />


---

### View Parking Record

Allows users to search for a parking record using vehicle number and entry date-time.

<img width="653" height="333" alt="Screenshot 2026-02-13 123309" src="https://github.com/user-attachments/assets/264edf75-b71d-47e9-bc60-eb025f0d0d26" />


---

### Display Parking Details

Shows the complete parking information when a matching record is found.

<img width="619" height="275" alt="Screenshot 2026-02-13 123436" src="https://github.com/user-attachments/assets/3d513591-e2ed-436d-909f-b825ef7ecc9e" />


---

### View All Parking Records

Displays a list of all vehicles currently stored in the database.

<img width="687" height="261" alt="Screenshot 2026-02-13 123341" src="https://github.com/user-attachments/assets/43be2381-ca2d-41ec-b5d3-bd2f448c7ea3" />
<img width="619" height="453" alt="Screenshot 2026-02-13 123349" src="https://github.com/user-attachments/assets/ca62829f-03f3-4a15-a189-b16793c39821" />

---

## Test Scenarios

- Add record with valid data
- Handle invalid inputs
- Prevent duplicate entries
- View existing and non-existing records
- Fetch all records when database is empty

---


## Student Details

- **Vishva Dharshini**

- **717823P161**
