# Full Stack Form Application

A simple full-stack web application built with HTML, CSS, JavaScript frontend and Spring Boot backend with MySQL database integration.

![Screenshot 2025-06-05 002712](https://github.com/user-attachments/assets/f3ea4a04-bdef-4a64-8c49-4c132c3f9f72)


## Features

- **CRUD Operations**: Create, Read, and Delete form data
- **Real-time Updates**: Automatic table refresh after operations
- **Responsive Design**: Clean and simple user interface
- **REST API**: RESTful endpoints for data management
- **Database Integration**: MySQL database with JPA/Hibernate

## Tech Stack

### Frontend
- HTML5
- CSS3
- Vanilla JavaScript
- Fetch API for HTTP requests

### Backend
- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- MySQL Database
- Lombok
- Maven

## Project Structure

```
HTML + Springboot/
├── front-end/
│   ├── index.html
│   ├── script.js
│   └── styles.css
└── back-end/
    └── demo/
        ├── src/main/java/com/example/demo/
        │   ├── DemoApplication.java
        │   ├── controller/FormController.java
        │   ├── entity/FormData.java
        │   ├── repository/FormRepository.java
        │   └── service/FormService.java
        ├── src/main/resources/
        │   └── application.properties
        └── pom.xml
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- MySQL Server
- Maven
- Modern web browser

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd "HTML + Springboot/back-end/demo"
   ```

2. **Configure MySQL Database**
   - Create a MySQL database or let Spring Boot create it automatically
   - Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/form-data-for-oop-practice?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Run the Spring Boot Application**
   ```bash
   ./mvnw spring-boot:run
   # or on Windows
   mvnw.cmd spring-boot:run
   ```

   The backend server will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd "../front-end"
   ```

2. **Open in browser**
   - Simply open `index.html` in your web browser
   - Or use a local server like Live Server extension in VS Code

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/form-data` | Create new form data |
| GET | `/api/read-form-data` | Retrieve all form data |
| DELETE | `/api/form-data/{id}` | Delete form data by ID |

## Usage

1. **Submit Form Data**
   - Fill in the form fields (Name, Email, Gender, Phone)
   - Click "Submit" button
   - Data will be saved to the database

2. **View Data**
   - All submitted data appears in a table below the form
   - Table automatically refreshes after operations

3. **Delete Data**
   - Click the "Delete" button in any table row
   - Data will be removed from the database

## Database Schema

The `FormData` entity contains:
- `id` (Long) - Auto-generated primary key
- `name` (String) - User's name
- `email` (String) - User's email address
- `gender` (String) - User's gender
- `phone` (String) - User's phone number

  ![Screenshot 2025-06-05 002837](https://github.com/user-attachments/assets/48fbfe4d-8484-47cb-8705-50caba7b0278)


## Dependencies

### Backend Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector/J
- Lombok
- Spring Boot Starter Test

### Frontend Dependencies
- No external dependencies (Vanilla JavaScript)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).
