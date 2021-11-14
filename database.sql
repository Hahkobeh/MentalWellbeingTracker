DROP DATABASE IF EXISTS MWT;
CREATE DATABASE MWT;
USE MWT;


DROP TABLE IF EXISTS Moods;
CREATE TABLE Moods (
                              EntryID		int not null auto_increment unique,
                              date          date not null,
                              MoodRating	int not null,
                              primary key (EntryID)
);


