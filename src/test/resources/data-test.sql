CREATE TABLE pet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    petType VARCHAR(10) NOT NULL,
    trackerType VARCHAR(10) NOT NULL,
    ownerId INT NOT NULL,
    inZone BOOLEAN NOT NULL,
    lostTracker BOOLEAN
);


INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 1, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 3, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'rfid', 5, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 7, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 9, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 11, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 13, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 15, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 17, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'rfid', 19, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 21, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 23, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 25, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone) VALUES
('dog', 'gps', 27, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 2, TRUE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 4, TRUE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 6, TRUE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'gps', 8, TRUE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'gps', 10, TRUE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 12, TRUE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 14, TRUE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 16, FALSE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 18, FALSE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 20, FALSE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'gps', 22, FALSE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'gps', 24, FALSE, TRUE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 26, FALSE, FALSE);
INSERT INTO pet (petType, trackerType, ownerId, inZone, lostTracker) VALUES
('cat', 'rfid', 30, FALSE, TRUE);