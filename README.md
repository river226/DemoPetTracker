# Simple Pet Tracker

This application provides a RESTful API for managing pet information. It allows users to create, read, update pet records. As well as provide an organized count of Pets in zone.

Language - Java 21  
Framework - Spring Boot 3.4.5  
Database - H2 (In Memory)  
Build Tool - Gradle 8.13-bin 

## How to Run
1. Clone the Repository
1. Navigate to the project directory
1. Build the application using:
   ```bash
   ./gradlew clean build
   ```
1. Run the application using:
   ```bash
   ./gradlew bootRun
   ```
   
This should run the application on `localhost:8080`. Check the output though to confirm the port `Tomcat started on port 8080 (http) with context path '/'`. as pulled from:

```bash
  INFO 63411 --- [PetTracker] [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
  INFO 63411 --- [PetTracker] [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
  WARN 63411 --- [PetTracker] [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
  INFO 63411 --- [PetTracker] [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
  INFO 63411 --- [PetTracker] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
  INFO 63411 --- [PetTracker] [           main] x.j.PetTracker.PetTrackerApplication     : Started PetTrackerApplication in 1.998 seconds (process running for 2.319)
```

## How to Test
Run the Unit tests using:
   ```bash
   ./gradlew test
   ```
Integration Tests are part of the provided [Postman Collection](./PetTracker.postman_collection.json)

The collection can be imported into Postman, and run using the Postman Runner. To use the runner: Select the collection and Select the runner button (or if running the VS Code Postman extension, select the dot menu next to the collection name and select "Run Collection"). 

In the Runner Screen you can select the run button and if you have the app running at localhost:8080, you should get 44 passed Test casses and nothing failed. 

This is a Fragile test, and it's current version is hardcoded to the current state of the application. If you change the application. You may need to update the URL if the port changes. 

### Pets Types:
- CAT
- DOG

### Other Tracked Fields:
- ID (Generated, Int)
  - the unique identifier for the record
- Tracker Type (String)
  - Implemented as a String to support diverse types
- Owner ID (Int)
  - Identifier for the owner of the pet
- Inzone 
  - Tells us if the pet is in a specified zone or not
- Lost Tracker _**Cat Only**_ (True/False)
  - Tells us if the pet (read cat) has managed to lose its tracker or not


### API:
**GET** `/` - Retrieve all pets

Response:
```json
[
    {
        "id": 1,
        "petType": "DOG",
        "trackerType": "Bluetooth",
        "ownerId": 123,
        "inZone": true,
        "lostTracker": null
    }
]
```

**GET** `/id/{id}` - Retrieve a pet by ID

Response:
```json
{
    "id": 1,
    "petType": "DOG",
    "trackerType": "Bluetooth",
    "ownerId": 123,
    "inZone": true,
    "lostTracker": null
}
```

**GET** `/inzone` - Pull all pets back and organizes them by Pet Type then Tracker Type to count the number of pets in the zone. 

Response: 
```json
{
    "dogs": [
        {
            "trackerType": "Bluetooth",
            "totalInZone": 1,
            "totalOutZone": 0
        }
    ],
    "cats": []
}
```

**POST** `/` - Allows you to add a Pet to the DB. ID is auto-generated.

*Passed in Object is Validated to for database input*

Request (Dog):
```json
{
  "petType": "DOG",
  "trackerType": "Bluetooth",
  "ownerId": 123,
  "inZone": true
}
```

Request (Cat):
```json
{
  "petType": "DOG",
  "trackerType": "Bluetooth",
  "ownerId": 123,
  "inZone": true,
  "lostTracker": false
}
```

Response: The Auto-Generated ID
```json
1
```





