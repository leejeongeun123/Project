package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;



class Student {
	String name;
	int score;

	public Student(String name, int score) {

		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

}


public class StreamExample2 {
	public static void main(String[] args) {
		// 최재영, 90 / 민해주 88 / 김상민 83/ 최형준 86
		// score >= 85 몇명인지 ? rCnt 변수에 담아주세요.
		// 리스트출력
		List<Student> list = Arrays.asList(new Student("최재영", 90), new Student("민해주", 88), new Student("김상민", 83),
				new Student("최형준", 86));

		Stream<Student> students = list.stream();
		long iCnt = students.filter(new Predicate<Student>() { // Predicate 매개값도 받고, 리턴타입으로 boolean 매개값이 true이면
			@Override
			public boolean test(Student t) {
				return t.score >= 85;
			}

		}).peek(new Consumer<Student>() { // 중간

			@Override
			public void accept(Student t) {
				System.out.println(t.name + ", " + t.score);
			}
		}).count();
		System.out.println("총인원 : " + iCnt);

	}
}
