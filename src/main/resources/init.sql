CREATE SCHEMA IF NOT EXISTS eventshuffle;
SET SCHEMA eventshuffle;

CREATE TABLE IF NOT EXISTS events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (250)
);

CREATE TABLE IF NOT EXISTS dates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    date DATE,
    FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE IF NOT EXISTS votes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    date_id INT,
    name VARCHAR(250),
    FOREIGN KEY (event_id) REFERENCES events(id),
    FOREIGN KEY (date_id) REFERENCES dates(id)
);