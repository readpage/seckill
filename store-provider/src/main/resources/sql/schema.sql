CREATE TABLE IF NOT EXISTS user (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(32) NOT NULL,
    password varchar(255) NOT NULL,
    UNIQUE(username)
);

CREATE TABLE IF NOT EXISTS role (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(32),
    UNIQUE(name)
);

CREATE TABLE IF NOT EXISTS user_role (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    uid int(11) NOT NULL,
    rid int(11) DEFAULT 3,
    FOREIGN KEY(uid) REFERENCES user(id),
    FOREIGN KEY(rid) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS menu (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pattern varchar(50),
    UNIQUE(pattern)
);

CREATE TABLE IF NOT EXISTS menu_role (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mid int(11),
    rid int(11),
    FOREIGN KEY(mid) REFERENCES menu(id),
    FOREIGN KEY(rid) REFERENCES role(id)
);

DROP TRIGGER IF EXISTS ur_delete;
DROP TRIGGER IF EXISTS mr_delete;

CREATE TRIGGER ur_delete
    BEFORE DELETE
    ON user
    FOR EACH ROW
    DELETE FROM user_role
    WHERE uid=old.id;

CREATE TRIGGER mr_delete
    BEFORE DELETE
    ON menu
    FOR EACH ROW
    DELETE FROM menu_role
    WHERE mid=old.id;