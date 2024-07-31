# devicemanagement
Device Managment Project sample

## Requirements

- Java 11 or higher
- Maven
- Postman (For API testing)

## Project Setup
Clone the repository:

    git clone <repository-url>
    cd devicemanagment
	

## Running the Application

1. Navigate to the project directory:
    cd devicemanagment

2. Run the application:
    mvn spring-boot:run
	
The application will start and be accessible at `http://localhost:8080`.

## API Endpoints

### 1. Add Device
- **URL:** `http://localhost:8080/api/devices`
- **Method:** POST
- **Headers:** `Content-Type: application/json`
- **Body:**
    ```json
    {
        "name": "IPhone 15",
        "brand": "Apple"
    }
    ```

### 2. Get Device by Identifier
- **URL:** `http://localhost:8080/api/devices/{id}`
- **Method:** GET
- **Example:** `http://localhost:8080/api/devices/1`

### 3. List All Devices
- **URL:** `http://localhost:8080/api/devices`
- **Method:** GET

### 4. Update Device (Full Update)
- **URL:** `http://localhost:8080/api/devices/{id}`
- **Method:** PUT
- **Headers:** `Content-Type: application/json`
- **Body:**
    ```json
    {
        "name": "IPhone 15 Pro",
        "brand": "Apple"
    }
    ```
- **Example:** `http://localhost:8080/api/devices/1`

### 5. Partial Update Device
- **URL:** `http://localhost:8080/api/devices/{id}`
- **Method:** PATCH
- **Headers:** `Content-Type: application/json`
- **Body:**
    ```json
    {
        "name": "iPhone 12 Pro Max"
    }
    ```
- **Example:** `http://localhost:8080/api/devices/1`

### 6. Delete a Device
- **URL:** `http://localhost:8080/api/devices/{id}`
- **Method:** DELETE
- **Example:** `http://localhost:8080/api/devices/1`

### 7. Search Device by Brand
- **URL:** `http://localhost:8080/api/devices/search?brand={brand}`
- **Method:** GET
- **Example:** `http://localhost:8080/api/devices/search?brand=Apple`

## Database Schema

The `device` table schema:

CREATE TABLE device (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    creation_time TIMESTAMP NOT NULL
);

## Using Postman

1. Open Postman.
2. Use the sample URLs provided above to interact with the API.
3. Make sure the application is running on `http://localhost:8080`.

## H2 Console

Access the H2 console to view the in-memory database:

1. Open a browser and navigate to `http://localhost:8080/h2-console`.
2. Use the following settings:
    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **Username:** `sa`
    - **Password:** `password`
	
## Packaging as a WAR File

To package the application as a WAR file for deployment to a servlet container:

1. Modify `pom.xml` to set the packaging type to `war`:
    <packaging>war</packaging>

3. Package the application:
    mvn clean package

4. Deploy the resulting WAR file from the `target` directory to your servlet container.

5. Start the web server and launcht the configiured port with server name `<Server-Name>:<Port>/apr/devices`

	