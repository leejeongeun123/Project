package stream.collect;

import java.util.Arrays;
import java.util.List;

public class EX {
	public static void main(String[] args) {
		List<EX2> totalList = Arrays.asList(new EX2("홍길동", 10, EX2.Sex.MALE, EX2.City.Seoul),
				new EX2("팽강이", 1, EX2.Sex.FEMALE, EX2.City.Seoul),
				new EX2("염퍙강", 3, EX2.Sex.MALE, EX2.City.Pusan),
				new EX2("평강염", 5, EX2.Sex.FEMALE, EX2.City.Seoul));
		
	}
}
