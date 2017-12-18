CREATE TABLE users
(
  id       INT AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  name     VARCHAR(50)  NOT NULL,
  date     DATE         NOT NULL,
  role     INT(1)       NOT NULL
  COMMENT ' 1 is Admin, 2 is User, 0 is Blocked',
  CONSTRAINT users_email_uindex
  UNIQUE (email)
)
  COMMENT 'all users';

CREATE TABLE list
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(150) NOT NULL,
  comment     VARCHAR(150) NULL,
  user_id     INT(11)      NOT NULL,
  date        DATE         NOT NULL
);

CREATE TABLE task
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  task    VARCHAR(150) NOT NULL,
  list_id     INT(11)      NOT NULL,
  chek        INT(1)        NOT NULL
);



INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user1@ukr.net", "1111", "user1", "2017-11-28", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user2@ukr.net", "1111", "user2", "2017-11-28", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user3@ukr.net", "1111", "user3", "2017-11-28", 2);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user4@ukr.net", "1111", "user4", "2017-11-28", 1);

INSERT INTO `users` (`email`, `password`, `name`, `date`, `role`)
VALUES ("user5@ukr.net", "1111", "user5", "2017-11-28", 1);

INSERT INTO `list` (`name`, `comment`, `user_id`, `date`)
VALUES ("list1", "comment list1", 1, "2017-11-29");

INSERT INTO `list` (`name`, `comment`, `user_id`, `date`)
VALUES ("list2", "comment list2", 1, "2017-11-29");

INSERT INTO `list` (`name`, `comment`, `user_id`, `date`)
VALUES ("list3", "comment list3", 2, "2017-11-29");

INSERT INTO `list` (`name`, `comment`, `user_id`, `date`)
VALUES ("list4", "comment list4", 3,"2017-11-29");

INSERT INTO `task` (`task`, `list_id`, `chek`)
VALUES ("хліб", 1, 0);

INSERT INTO `task` (`task`, `list_id`, `chek`)
VALUES ("мука", 1, 0);

INSERT INTO `task` (`task`, `list_id`, `chek`)
VALUES ("прогулятися", 2, 0);

INSERT INTO `task` (`task`, `list_id`, `chek`)
VALUES ("нагадати", 1, 0);