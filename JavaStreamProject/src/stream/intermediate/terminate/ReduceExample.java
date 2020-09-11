package stream.intermediate.terminate;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.EmpDAO;
import stream.intermediate.Employee;

public class ReduceExample {
	public static void main(String[] args) {
		//사원의 평균급여를 계산.
		List<Employee>empList = EmpDAO.getEmpList();
		//전체 사원의 컬렉션을 통해 스트림 생성하세요.\
		Stream<Employee> stream = empList.stream();
		//Employee -> InStream 매핑.
		OptionalDouble avg = stream
				.filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getJobId().equals("IT_PROG");
				
			}
			
		
		}).flatMapToInt(new Function<Employee, InStream>(){
			return InStream.of(t.getSalary());
			
		}
	}).average();
		
		System.out.println("평균급여는"+ avg);
	}
}
