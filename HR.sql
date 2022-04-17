create database HResource;
use HResource;

create table Employee(ID int primary key, 
	DOJ date, E_Name varchar(30), Gender varchar(10), DOB date, 
	Address varchar(150), Qualification varchar(30), Experience varchar(30), 
    Position varchar(30), Department varchar(30), Salary int);
    
create table Project(ID int primary key,
	Project_Name varchar(50), P_Description varchar(100), Start_Date date, End_Date date
    );

create table Dependent(
	Emp_ID int, Dep_Name varchar(30), DOB Date, Relation varchar(100),
    foreign key(Emp_ID) references Employee(ID)
    );
    
create table Assignments(
	Assignment_ID int, Emp_ID int, Project_ID int, 
    From_Date date, Upto_Date date,
    foreign key(Emp_ID) references Employee(ID),
    foreign key(Project_ID) references Project(ID)
    );

select * from Employee;
select * from Project;
select * from Dependent;
select * from Assignments;
select max(ID) from Employee;

drop table Dependent;
drop table Assignments;