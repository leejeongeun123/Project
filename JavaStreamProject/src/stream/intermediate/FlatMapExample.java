package stream.intermediate;

import java.nio.file.DirectoryStream.Filter;
import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		stream.flatMap(new Function<Integer, Stream<Integer>>() {// Functrion, Integer로 받아서 반환하는 타입은 Stream
			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t * 3); // return stream타입으로 반환.
			}
		}).forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);

			}

		});
		DoubleStream.of(0.3);

//		Employee.employees().stream().flatMapToDouble(new Function<Employee, DoubleStream>() {
//
//			@Override
//			public DoubleStream apply(Employee t) {
//				
//				return DoubleStream.of(t.income);
//				
//			}
//		}).filter(n -> n > 7000).max();	
//		
//		if (result.isPresent())
//			System.out.println("result : " + result);
//		else
//			System.out.println("결과없음");
//		
//		}).forEach(new DoubleConsumer() {
//			
//			@Override
//			public void accept(double value) {
//				System.out.println(value);
//				
//			}
//		});
//		
//		Employee.employees().stream().flatMap(new Function<Employee, Stream<? extends String>>() {
//			@Override
//			public Stream<String> apply(Employee t) {
//				return Stream.of(t.getName());
//			}
//		}).findFirst().ifPresent(System.out::println);
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee, DoubleStream>() {

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
//		}).filter(n -> n > 2000).reduce(new DoubleBinaryOperator() {
//			
//			@Override
//			public double applyAsDouble(double left, double right) {
//				
//				return left < right ? left : right;
//			}
		}).reduce((left,right)-> left+right);
			if(result.isPresent())
				System.out.println("result : " + result );
			else
				System.out.println("결과 없음");
		


		
		
		Optional<LocalDate> result2 = Employee.employees().stream()
				.flatMap(new Function<Employee, Stream<LocalDate>>() {

			@Override
			public Stream<LocalDate> apply(Employee t) {
				return Stream.of(t.getDateOfBirth());
			}

		}).reduce(new BinaryOperator<LocalDate>() {
			@Override
			public LocalDate apply(LocalDate t, LocalDate u) {
				System.out.println(t + "," + u);
				return t.isBefore(u) ? u : t;
			}
		});
		System.out.println("min 값" + result2);

	}
}
