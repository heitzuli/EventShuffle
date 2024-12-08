CREATE SCHEMA IF NOT EXISTS eventshuffle;
SET SCHEMA eventshuffle;

CREATE TABLE IF NOT EXISTS events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (250)
);

CREATE TABLE IF NOT EXISTS dates (
    date_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    date DATE,
    FOREIGN KEY (event_id) REFERENCES events(id)
);

CREATE TABLE IF NOT EXISTS votes (
    vote_id INT AUTO_INCREMENT PRIMARY KEY,
    date_id INT,
    person VARCHAR(250),
    FOREIGN KEY (date_id) REFERENCES dates(id)
);