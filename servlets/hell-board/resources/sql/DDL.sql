CREATE TABLE PUBLIC.USER
(
  userNo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  userId VARCHAR2(100) NOT NULL,
  userName VARCHAR2(100) NOT NULL,
  password VARCHAR2(100) NOT NULL
);
CREATE UNIQUE INDEX "USER_userNo_uindex" ON PUBLIC.USER (userNo);
COMMENT ON TABLE PUBLIC.USER IS '사용자';

CREATE TABLE PUBLIC.CONTENT
(
  contentNo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  userId VARCHAR2(100) NOT NULL,
  subject VARCHAR2(1000) NOT NULL,
  text BLOB NOT NULL,
  registrationDateTime DATETIME NOT NULL
);
CREATE UNIQUE INDEX "CONTENT_contentNo_uindex" ON PUBLIC.CONTENT (contentNo);
COMMENT ON TABLE PUBLIC.CONTENT IS '게시물';

/*
DROP PUBLIC.USER
DROP PUBLIC.CONTENT
*/