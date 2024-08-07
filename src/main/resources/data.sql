insert into todo ( id, userid, description, targetDate, done ) values ( 1000,'inky4832', 'Learn SpringBoot2.1.8', DATE_ADD(NOW(), INTERVAL 1 YEAR), false);
insert into todo ( id, userid, description, targetDate, done ) values ( 1001,'inky4832', 'Learn Reactjs', DATE_ADD(NOW(), INTERVAL 1 MONTH), false);
insert into todo ( id, userid, description, targetDate, done ) values ( 1002,'inky4832', 'Learn SpringSecurity', DATE_ADD(NOW(), INTERVAL 10 DAY), false);
insert into todo ( id, userid, description, targetDate, done ) values ( 200,'ryu4832', 'Learn Dance', DATE_ADD(NOW(), INTERVAL 3 YEAR), false);


-- 1234에 해당되는 암호화 값은 $2a$10$MzsW3Sb43XuVhHO0l6kbEOhGIlBwkK1Tx.zxv7G6hDlZ1VzmfHeYO 임
insert into member ( userid, password, username, role ) values ( 'inky4832','$2a$10$MzsW3Sb43XuVhHO0l6kbEOhGIlBwkK1Tx.zxv7G6hDlZ1VzmfHeYO','인경열','ADMIN');
insert into member ( userid, password, username, role ) values ( 'ryu4832','$2a$10$MzsW3Sb43XuVhHO0l6kbEOhGIlBwkK1Tx.zxv7G6hDlZ1VzmfHeYO','유관순','USER');