PREPARE COMMIT admin;

INSERT INTO PUBLIC.MEMBER (
       memberId
     , menberName
     , password
     )
VALUES (
       'admin'
     , '관리자'
     , '1234'
     );

COMMIT;

SELECT *
  FROM PUBLIC.MEMBER
 WHERE memberId = 'admin';