drop table if exists test.recipe;
drop table if exists test.ingredient;
drop table if exists test.statistics;

CREATE TABLE if not exists test.recipe(id INT, name VARCHAR(30),coffee INT, water INT, milk INT);
CREATE TABLE if not exists test.ingredient(id INT, name VARCHAR(30), count INT);
CREATE TABLE if not exists test.statistics(id INT, name VARCHAR(30), count INT,date DATE);
