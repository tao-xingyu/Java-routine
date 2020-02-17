CREATE  Table users(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(200) NOT NULL UNIQUE ,
nickname VARCHAR (200) NOT NULL,
password CHAR(64) NOT NULL COMMEMT
);
CREATE TABLE articles(
id INT PRIMARY KEY AUTO_INCREMENT,
author_id INT NOT NULL,
title VARCHAR(255) NOT NULL,
content TEXT NOT NULL,
published_at DATETIME NOT NULL
);
CREATE TABLE comments(
id INT PRIMARY KEY AUTO_INCREMENT,
author_id INT NOT NULL,
article_id INT NOT NULL,
content VARCHAR (200),
published_at DATETIME NOT NULL
);
CREATE TABLE user_like_article_relations(
user_id INT NOT NULL,
article_id INT NOT NULL,
PRINARY KEY(user_id,article_id)
);

--注册用户
INSERT INTO users (username,nickname,password)VALUES(?,?,?);

-- 用户登录
SELECT id, username,nickname FROM user WHERE username = ? AND password = ? ;