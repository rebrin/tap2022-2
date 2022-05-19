create database EjConsultas;
use EjConsultas;

create table DEPT(depno INTEGER PRIMARY KEY,
 dname VARCHAR(15) NOT NULL,
	loc VARCHAR(15) NOT NULL);
	
INSERT INTO DEPT (depno,dname,loc) values(1,"ventas","Buenos Aires");
INSERT INTO DEPT (depno,dname,loc) values(2,"compras","Buenos Aires");
INSERT INTO DEPT (depno,dname,loc) values(3,"RH","La Plata");
	
CREATE TABLE emp(empno INTEGER PRIMARY KEY,
	ename VARCHAR(15) NOT NULL,
	depno INTEGER REFERENCES DEPT.depno,
	hiredate DATE NOT NULL);	
	
INSERT INTO emp(empno,ename,depno,hiredate)values
			(10,"juan",1,"1990/05/02");
			
INSERT INTO emp(empno,ename,depno,hiredate)values
			(20,"Alberto",3,"1993/01/03");
			
INSERT INTO emp(empno,ename,depno,hiredate)values
			(30,"Pedro",1,"1985/06/02");
INSERT INTO emp(empno,ename,depno,hiredate)values
			(40,"marcos",2,"1998/12/05");
INSERT INTO emp(empno,ename,depno,hiredate)values
			(50,"jaime",2,"1982/11/07");
INSERT INTO emp(empno,ename,depno,hiredate)values
			(60,"pablo",1,"1996/10/07");			
			
//producto cartesiano
select *
from emp,dept
where emp.depno=dept.depno;
//like todos los empleados con o en su nombre
select *
from emp
where ename like '%o%';
//cambio
UPDATE emp
SET ename='Pablo L',depno=3
where empno=60;
