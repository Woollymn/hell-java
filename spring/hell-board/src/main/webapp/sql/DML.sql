PREPARE COMMIT admin;

INSERT INTO PUBLIC.USER (
       USERID
     , USERNAME
     , PASSWORD
     )
VALUES (
       'admin'
     , '관리자'
     , '1234'
     );

COMMIT;

SELECT *
  FROM PUBLIC.USER
 WHERE USERID = 'admin';