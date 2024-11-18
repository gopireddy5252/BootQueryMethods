package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IQueryMethodsRepository;
@Component
public class QueryMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IQueryMethodsRepository queryrepo;

	@Override
	public void run(String... args) throws Exception {
		
		//queryrepo.showAllEmpDetails().forEach(System.out::println);
		
		//queryrepo.showEmpsBySalaryRange(50000, 70000).forEach(System.out::println);;
		
		/* queryrepo.showEmpsBydesgs("hr", "emp", "manager").forEach(System.out::println);
		System.out.println("_________________________________________________");
		queryrepo.showSomeDataBydesgs("manager", "clerk", "clerk").forEach(row->{
			for(Object val:row)
			{
				System.out.print(val+" ");
			}
			System.out.println();
		});
		System.out.println("____________________________________________________");
		queryrepo.showDataBydesgs("d%").forEach(System.out::println); */
		
		Object data=queryrepo.fectchEmpsDataByName("kali");
		Object[]row=(Object[])data;
		System.out.println("Single record multiple values::"+Arrays.toString(row));
		
		System.out.println("unique deptno count::"+queryrepo.showDeptnoUniqueCount());
		
		Object[] row1=(Object[])queryrepo.showAggregateData();
		System.out.println("Aggregate Data::"+Arrays.toString(row1));
	}

}
