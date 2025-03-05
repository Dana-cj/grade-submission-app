# Grade Submission Application

## Overview
The Grade Submission Application is a Spring Boot RESTful API that manages students, courses, and grades. It allows CRUD operations on these entities and uses an H2 in-memory database for easy setup and testing.

## Features
- **Student Management**: Add, retrieve, delete, and list students.
- **Course Management**: Create, retrieve, delete, and enroll students in courses.
- **Grade Management**: Assign, update, delete, and retrieve student grades.

## Technologies Used
- **Spring Boot**: Core framework for building RESTful APIs.
- **Maven**: Dependency management and project structure.
- **H2 Database**: In-memory database for development and testing.
- **Spring Data JPA**: Simplified data access with Hibernate.
- **Spring Web**: RESTful web services.
- **Lombok**: Simplifies boilerplate code (e.g., getters, setters).
- **Spring Boot DevTools**: Provides live reload and development tools.
- **Spring Boot Starter Test**: Testing framework for unit and integration tests.

## Setup Instructions

### Prerequisites
Ensure you have the following installed:
- Java 17 or later
- Maven 3.8+

### Clone the Repository
```bash
 git clone https://github.com/your-repo/grade-submission.git
 cd grade-submission
```

### Build and Run the Application
1. Package the application:
   ```bash
   mvn clean install
   ```
2. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Access the API
The API will be accessible at: `http://localhost:8080`

## API Endpoints

### Student Controller
| Method  | Endpoint                | Description                  |
|---------|-------------------------|------------------------------|
| GET     | /student/{id}           | Retrieve a student by ID     |
| GET     | /student/all            | Retrieve all students        |
| POST    | /student                | Create a new student         |
| DELETE  | /student/{id}           | Delete a student by ID       |

### Course Controller
| Method  | Endpoint                        | Description                          |
|---------|---------------------------------|--------------------------------------|
| GET     | /course/{id}                    | Retrieve a course by ID              |
| GET     | /course/all                     | Retrieve all courses                 |
| POST    | /course                         | Create a new course                  |
| DELETE  | /course/{id}                    | Delete a course by ID                |
| PUT     | /course/{courseId}/student/{studentId} | Enroll a student in a course         |
| GET     | /course/students/{courseId}     | Retrieve students in a specific course|

### Grade Controller
| Method  | Endpoint                                      | Description                        |
|---------|-----------------------------------------------|------------------------------------|
| GET     | /grade/student/{studentId}/course/{courseId}  | Retrieve a grade by student & course|
| GET     | /grade/student/{studentId}                    | Retrieve all grades of a student    |
| GET     | /grade/course/{courseId}                      | Retrieve all grades in a course     |
| GET     | /grade/all                                    | Retrieve all grades                 |
| POST    | /grade/student/{studentId}/course/{courseId}  | Create a grade for a student        |
| PUT     | /grade/student/{studentId}/course/{courseId}  | Update a grade                     |
| DELETE  | /grade/student/{studentId}/course/{courseId}  | Delete a grade                     |

## H2 Database Console
Access the H2 in-memory database console at:
```
http://localhost:8080/h2/login.jsp
```

Use the following JDBC URL to connect:
```
jdbc:h2:mem:grade-submission
```

## Future Enhancements
- Implement authentication and authorization (e.g., Spring Security).
- Add pagination and sorting for large datasets.
- Integrate OpenAPI/Swagger documentation.

## License
This project is licensed under the MIT License.

