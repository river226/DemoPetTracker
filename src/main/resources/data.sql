CREATE TABLE pet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    petType VARCHAR(10) NOT NULL,
    trackerType VARCHAR(10) NOT NULL,
    ownerId INT NOT NULL,
    inZone BOOLEAN NOT NULL,
    lostTracker BOOLEAN
);