package stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
		// 1 ~ 10까지 정수형 배열.
		// 배열로 부터 스트림을 생성하는 바업ㅂ.
		// 스트림을 생성하고 filter를 통해서 짝수값을
		// 최종집계처리는 sum() 을 가져오는코드구현.
		IntStream.range(1, 10).forEach(s->System.out.println(s));
		System.out.println("-- rangeClosed");	// 1~9 출력
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		System.out.println("--------------");	// 1~10
		IntStream.rangeClosed(1, 10).filter(n -> n >5).forEach(System.out::println);
		System.out.println("--------------");	// filter 사용으로 5~10출력
		
		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = Arrays.stream(intArray);
		
		double sum = intStream.filter(new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		}).peek(new IntConsumer() {
			
			@Override
			public void accept(int value) {
				System.out.println(value);
				
			}
		}).sum();
		
		System.out.println(sum);
		
		
		
		
	}
}
