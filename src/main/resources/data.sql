--table schemas


DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS fees;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS "role";
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS flats CASCADE ;
DROP TABLE IF EXISTS blocks;





CREATE TABLE blocks
(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE flats
(
    flat_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    flat_number INT NOT NULL,
    block_id INT NOT NULL,
    --payment_id INT NOT NULL,
    FOREIGN KEY(block_id) REFERENCES blocks(id)
    --FOREIGN KEY(payment_id) REFERENCES payments(id)

);

CREATE TABLE "user"
(
    id       INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(24) UNIQUE NOT NULL,
    email    VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255)  NOT NULL
);

CREATE TABLE "role"
(
    id        INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    role_name varchar(10) UNIQUE NOT NULL
);

CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE fees
(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    electricity_bill INT DEFAULT 0,
    gas_bill INT DEFAULT 0,
    water_bill INT DEFAULT 0,
    dues INT DEFAULT 0,
    flat_id INT NOT NULL,
    --total_fee INT ALWAYS AS SUM  ,electricity_bill,gas_bill,water_bill,dues ,
    FOREIGN KEY(flat_id) REFERENCES flats(flat_id)
);

CREATE TABLE payments
(
    id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    --flat_id INT NOT NULL,
    payment_amount INT NOT NULL
    --FOREIGN KEY(flat_id) REFERENCES flats(flat_id)
    --FOREIGN KEY(total_fee) REFERENCES fees(total_fee)

);


INSERT INTO "role" (role_name)
VALUES ('ROLE_ADMIN');
INSERT INTO "role" (role_name)
VALUES ('ROLE_USER');





INSERT INTO blocks(name)
VALUES ('A1'),
       ('A2'),
       ('B1'),
       ('B2'),
       ('C');

INSERT INTO flats(flat_number,block_id)
VALUES (1,1),
       (2,1),
       (1,2),
       (2,2),
       (1,3),
       (1,4),
       (1,5);


INSERT INTO "user" (username,email,password)
VALUES ('zeynel','admin@adminonline.com','zeynel123');

INSERT INTO user_roles(user_id,role_id)
VALUES (1,1);


INSERT INTO fees(electricity_bill,gas_bill,water_bill,dues,flat_id)
VALUES (100,100,100,50,1),
       (100,100,100,50,2),
       (100,100,100,50,3),
       (100,100,100,50,4),
       (100,100,100,50,5),
       (100,100,100,50,6),
       (100,100,100,50,7);


