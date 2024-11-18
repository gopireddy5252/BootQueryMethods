package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee;

public interface IQueryMethodsRepository extends JpaRepository<Employee, Integer> {
	//@Query("from Employee")
	//@Query("from Employee emp")
	//@Query("from com.nt.entity.Employee emp")  // as is optional here
	@Query("select emp from com.nt.entity.Employee as emp")
	public List<Employee> showAllEmpDetails();
	
	//@Query("from Employee where sal>=?1 and sal<=?2")
	@Query("from Employee where sal>=:start and sal<=:end") //this one is best
	public List<Employee> showEmpsBySalaryRange(int start,int end);
	
	@Query("from Employee where desg in(:desg1,:desg2,:desg3)")//Entity query
	public List<Employee> showEmpsBydesgs(String desg1,String desg2,String desg3);
	
	@Query("select eid,ename,sal from Employee where desg in(:desg1,:desg2,:desg3)")//scaler query getting multiple column values
	public List<Object[]> showSomeDataBydesgs(String desg1,String desg2,String desg3);
	
	@Query("select ename from Employee where desg Like:initChars")// scaler query getting single column value
	public List<String> showDataBydesgs(String initChars);
	
	@Query("select eid,ename,sal from Employee where ename=:name")//single record scalar query giving multiple values
	public Object fectchEmpsDataByName(String name);
	
	@Query("select count(distinct deptno) from Employee")
	public long showDeptnoUniqueCount();
	
	@Query("select count(*),max(sal),min(sal),avg(sal),sum(sal) from Employee")
	public Object showAggregateData();
	
}
