package stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class DoubleStreamExample {
	public static void main(String[] args) {
		double []dAry = {2.3, 4.5, 8.3, 5.5, 4.6};
		// 스트림을 생성하고 5보다 작은 반복요소를 필터하고 합을 구하세요.

//		DoubleStream dStream = Arrays.stream(dAry);
//	
//		double DS  = dStream.filter(value -> value<5)
//		.peek(value -> System.out.println(value))
//		.sum();
//		System.out.println(DS);
//		.forEach(value -> System.out.println(value));
	}
}
