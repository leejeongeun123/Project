package stream.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Gender {
	MALE, FEMALE;
}

class Student {
	String name;
	int age;
	Gender gender;

	public Student(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

}

public class CollectToListExample {
	public static void main(String[] args) {
		Student s1 = new Student("허성준", 25, Gender.MALE);
		Student s2 = new Student("최형준", 27, Gender.MALE);
		Student s3 = new Student("문선애", 29, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3);

		Collector<Student, ?, List<Student>> collector = Collectors.toList();
		List<Student> newList = students.stream()
//			.filter(s -> s.gender == Gender.MALE)//
//	.forEach(s -> System.out.println(s.name + ", " + s.age));
				.collect(collector);

		newList.stream().forEach(s -> System.out.println(s.name + "," + s.age));

		// 나이가 25 살 넘늠 사람들

		Set<Student> set = students.stream().filter(s -> s.age > 25).collect(Collectors.toSet());

		Iterator<Student> iter = set.iterator();
		while (iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s.name + ", " + s.age);

		}
	}
}