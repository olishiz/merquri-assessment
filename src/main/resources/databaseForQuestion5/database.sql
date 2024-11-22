-- Init the database

-- For this, I am using a local mysql database to connect and create a mock data in the database.
-- The database is called "test_database"
-- Please point it to your "test_database" in your SQL client and run this script.

-- Create the players table
CREATE TABLE players
(
    Player_no INT PRIMARY KEY,
    Name      VARCHAR(50)
);

-- Insert data into players table
INSERT INTO players (Player_no, Name)
VALUES (1, 'Alan'),
       (2, 'James'),
       (3, 'Alan'),
       (4, 'Bob');

-- Create the scores table
CREATE TABLE scores
(
    Player_no INT,
    Sport     VARCHAR(50),
    Score     INT
);

-- Insert data into scores table
INSERT INTO scores (Player_no, Sport, Score)
VALUES (3, 'Chess', 10),
       (3, 'Swimming', 20),
       (2, 'Swimming', 10),
       (1, 'Swimming', 5);

-- Answer for Question 5: SQL to show result
SELECT
    p.Name AS Name,
    s.Sport AS Sport,
    s.Score AS Total_Score
FROM
    players p
        JOIN
    scores s
    ON
        p.Player_no = s.Player_no
ORDER BY
    p.Name, s.Sport, s.Score;

