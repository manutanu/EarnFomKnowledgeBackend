--data insertion role tables 

INSERT INTO role (roleid,role) VALUES (1,"USER");
INSERT INTO role (roleid,role) VALUES (2,"ADMIN");

--data insertion for categories of quizes
INSERT INTO categories (categoryid,category_name) VALUES (1,"General Knowledge");
INSERT INTO categories (categoryid,category_name) VALUES (2,"Games");
INSERT INTO categories (categoryid,category_name) VALUES (3,"FootBall");
INSERT INTO categories (categoryid,category_name) VALUES (4,"Cricket");
INSERT INTO categories (categoryid,category_name) VALUES (5,"BasketBall");
INSERT INTO categories (categoryid,category_name) VALUES (6,"History");
INSERT INTO categories (categoryid,category_name) VALUES (7,"Politics");
INSERT INTO categories (categoryid,category_name) VALUES (8,"Geography");
INSERT INTO categories (categoryid,category_name) VALUES (9,"Reasoning");
INSERT INTO categories (categoryid,category_name) VALUES (10,"Biology");
INSERT INTO categories (categoryid,category_name) VALUES (11,"Mathematics");
INSERT INTO categories (categoryid,category_name) VALUES (12,"Computer Science");
INSERT INTO categories (categoryid,category_name) VALUES (13,"Swimming");
INSERT INTO categories (categoryid,category_name) VALUES (14,"Java");
INSERT INTO categories (categoryid,category_name) VALUES (15,"C");
INSERT INTO categories (categoryid,category_name) VALUES (16,"Python");


--data for League Types
INSERT INTO league_types (leaguetypeid,amount,description,league_name) VALUES (1,5,"Small Leagues have 10 questions With winning amount 8","Small Leagues");
INSERT INTO league_types (leaguetypeid,amount,description,league_name) VALUES (2,10,"Medium Leagues have 10 questions With winning amount 18","Medium Leagues");
INSERT INTO league_types (leaguetypeid,amount,description,league_name) VALUES (3,20,"Large Leagues have 10 questions With winning amount 38","Large Leagues");

--data for quiz questions == > answers
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (1,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (2,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (3,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (4,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (5,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (6,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (7,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (8,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (9,"option 1","option 4","option 1","option 3","option2");
INSERT INTO answer (answerid,optionfour,optionone,optionthree,optiontwo,rightoption) VALUES (10,"option 1","option 4","option 1","option 3","option2");


--data for quiz questions
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (1,"Question No. 1","easy",10,1,1);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (2,"Question No. 2","easy",10,1,2);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (3,"Question No. 3","easy",10,1,3);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (4,"Question No. 4","easy",10,1,4);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (5,"Question No. 5","easy",10,1,5);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (6,"Question No. 6","easy",10,1,6);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (7,"Question No. 7","easy",10,1,7);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (8,"Question No. 8","easy",10,1,8);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (9,"Question No. 9","easy",10,1,9);
INSERT INTO question (questionid,question_desc,level,timeinseconds,category_categoryid,options_answerid) VALUES (10,"Question No. 10","easy",10,1,10);
