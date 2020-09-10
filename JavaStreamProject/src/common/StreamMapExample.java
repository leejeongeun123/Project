package common;

import java.util.List;
import java.util.function.Predicate;

public class StreamMapExample {
	public static void main(String[] args) {
		EmpDAO emp = new EmpDAO();
		List<Employee> employees = emp.getEmpList();
		
		//salery가 10000 이상인 사원들 출력.
		
		employees.stream()
		.filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getSalary() > 10000;
			}
		}).forEach(System.out::println);

 	}
}	
