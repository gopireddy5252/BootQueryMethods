package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="emp")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Integer sal;
	private String desg;
	private Integer deptno;

}
