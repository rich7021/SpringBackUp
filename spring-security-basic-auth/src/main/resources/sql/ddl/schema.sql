DROP TABLE ACCOUNTS IF EXITS;

CREATE TABLE ACCOUNTS {
  ID NUMERIC PRIMARY KEY,
  USERNAME VARCHAR(60) NOT NULL,
  CREDENTIALS VARCHAR(20) NOT NULL
};