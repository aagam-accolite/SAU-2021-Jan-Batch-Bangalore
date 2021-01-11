/* Creating Database */
create database sqlassginment;

use sqlassginment;

/* Table Creation*/
create table players(
	p_id int primary key,
    p_name varchar(20),
    p_type varchar(20),
    run_scored int,
    wicket_taken int,
    m_played int,
    team_name varchar(20)
);

create table match_table(
	t_id int primary key,
	team_name varchar(20),
    m_played int,
    m_won int,
    total_runs int,
    total_wickets int
);

create table matches(
	m_id int PRIMARY KEY,
	t_id int,
    runs_scored_in_match int,
    wicket_taken int,
	FOREIGN KEY (t_id) REFERENCES match_table(t_id)
);

/* Insert Queries */

/* Team India */
insert into players values (1,'Rohit Sharma','batsman',230,0,3,'India');
insert into players values (2,'Virat kohli','batsman',350,0,2,'India');
insert into players values (3,'M.S Dhoni','batsman',230,0,1,'India');
insert into players values (4,'R Ashwin','bowler',0,4,3,'India');
insert into players values (5,'J Bumrah','bowler',0,2,3,'India');

/* Team Pakistan */
insert into players values (6,'S Malik','batsman',140,0,2,'Pakistan');
insert into players values (7,'S Khan','batsman',250,0,3,'Pakistan');
insert into players values (8,'S Afridi','bowler',0,1,1,'Pakistan');
insert into players values (9,'F Zaman','bowler',0,2,2,'Pakistan');
insert into players values (10,'B Azam','bowler',0,1,3,'Pakistan');

/* Team Australia */
insert into players values (11,'M Wade','batsman',346,0,3,'Australia');
insert into players values (12,'A Finch','batsman',412,0,3,'Australia');
insert into players values (13,'A Cary','bowler',0,4,3,'Australia');
insert into players values (14,'P Cummins','bowler',0,1,3,'Australia');
insert into players values (15,'C Green','bowler',0,0,3,'Australia');

/* Team WestIndies */
insert into players values (16,'J Anderson','batsman',318,0,3,'WestIndies');
insert into players values (17,'A Rashid','batsman',298,0,2,'WestIndies');
insert into players values (18,'B Strokes','batsman',421,0,3,'WestIndies');
insert into players values (19,'T Curran','bowler',0,5,2,'WestIndies');
insert into players values (20,'J Vince','bowler',0,6,1,'WestIndies');

/* Points Table Insertion */
insert into match_table values(1,'India',3,2,810,6);
insert into match_table values(2,'Pakistan',3,1,390,4);
insert into match_table values(3,'Australia',3,2,758,5);
insert into match_table values(4,'WestIndies',3,2,1037,11);

/* Match Record Table Insertion */
insert into matches values(1,1,210,4);
insert into matches values(2,1,290,2);
insert into matches values(3,2,110,1);
insert into matches values(4,2,230,3);
insert into matches values(5,3,245,1);
insert into matches values(6,3,238,2);
insert into matches values(7,4,276,3);
insert into matches values(8,4,302,0);
insert into matches values(9,2,312,1);
insert into matches values(10,3,353,2);

/* Query  2*/
select * from players where p_type='batsman' order by run_scored desc limit 5;

/* Query  3*/
select * from players where p_type='bowler' order by wicket_taken desc limit 5;

/* Query 4*/
select team_name, total_runs/m_played as average from match_table order by total_runs/m_played;

/* Query 5*/

/*
    Average of Pakistan is lowest 
    hence players of pakistan score will be added by 10
*/
SET SQL_SAFE_UPDATES = 0;

update players set run_scored = run_scored + 10 where team_name =
 ( select team_name from match_table order by total_runs/m_played asc limit 1);
 
 select * from players where team_name = 'Pakistan';

/*Query 6 */
Select * from matches;

DELIMITER $$
drop procedure if exists highest_score$$
create procedure highest_score(team_name_input varchar(50), out highestScore int)
begin
	select max(runs_scored_in_match) into highestScore from matches join match_table on matches.t_id = match_table.t_id where match_table.team_name = team_name_input;
end$$

DELIMITER ;

call highest_score('India',@highestScore);
select @highestScore;


