package EX;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import common.Employee;

public class StreamMapExample {
	public static void main(String[] args) {
		EmpDAO emp = new EmpDAO();
		List<Employee> employees = emp.getEmpList();
		//salery가 10000 이상인 사원들 출력.
		employees.stream()
		.filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				
				return t.getHireDate().getYear()>1995;
			}
			
		}).forEach(new Consumer<Employee>(){

			@Override
			public void accept(Employee t) {
				System.out.println(t);
			}
		});
	}
}
