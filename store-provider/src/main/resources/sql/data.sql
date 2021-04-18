INSERT IGNORE INTO role VALUES
(1, 'dba'),
(2, 'admin'),
(3, 'user');

INSERT IGNORE INTO user VALUES
(1, 'root', '$2a$10$9dGTSRzO90qYpi2jmJSLMecFAYoMT4ijBGRZG2/pCZe.2AJLrUE.C'),   -- password:root
(2, 'admin', '$2a$10$xLbctedxEk/D3cv11LzFjOMRaBLk25SrWIidTETr1aa.Ho.0RZTba'),  -- admin
(3, 'user', '$2a$10$gG2uw7LB0OTyyDNrg9fnquJCe9QYtuOZ/Yj973sr6dGusLMjfSKJe');   -- user

INSERT IGNORE INTO user_role VALUES
(1, 1, 1), (2, 1, 2), (3, 1, 3),
(4, 2, 2), (5, 2, 3), (6, 3, 3);


INSERT IGNORE INTO menu VALUES
(1, '/dba/**'), (2, '/admin/**'), (3, '/user/**');

INSERT IGNORE INTO menu_role VALUES
(1, 1, 1), (2, 2, 1), (3, 3, 1),
(4, 2, 2), (5, 3, 2), (6, 3, 3)



