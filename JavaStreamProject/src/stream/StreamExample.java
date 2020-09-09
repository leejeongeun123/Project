package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// 컬렉션 => 외부반복자
		List<String> users = Arrays.asList("홍길동", "최재영", "민해주", "김상민");
		System.out.println("외부반복자 사용");
		Iterator<String> iter = users.iterator(); //반복자를 가져오는  iterator, 
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());
		}
		
		
		
		
		// 스트림 => 내부반복자
		System.out.println("내부반복자 사용");
		Stream<String> streams = users.stream();
		 //conumer타입의 익명개체를 가져옴.
		//람다식 사용가능 
		streams.forEach((t) -> System.out.println(t.toString()));

//2.
//		streams.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//			System.out.println(t.toString());
//			} 			
//		}); 
	}
}
