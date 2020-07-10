CREATE TABLE player
(
  id   INT,
  name VARCHAR(50),
  alias VARCHAR(20),
  number INT,
  position VARCHAR(40)
);

INSERT INTO player(id, name, alias, number, position)
VALUES (1, 'Pepito', 'Pep', 1, 'GOALKEEPER');

INSERT INTO player(id, name, alias, number, position)
VALUES (2, 'Luis', 'Luigi', 9, 'FORWARD');