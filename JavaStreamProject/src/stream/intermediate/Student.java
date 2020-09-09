package stream.intermediate;

import java.util.Objects;

public class Student implements Comparable<Student> {
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
		
	}
	// 동일이름, 점수일 경우 제거. 
	@Override
	public int hashCode() {
		return Objects.hashCode(this.name) + this.score;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
		Student that = (Student) obj;
		return this.name == that.name && this.score == that.score;
	}else {
		return false;
	}
	}
	
	//중복 이름 제거.
//	@Override
//	public int hashCode() {
//		return Objects.hashCode(this.name);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Student) {
//		Student that = (Student) obj;
//		return this.name == that.name;
//	}else {
//		return false;
//	}
//	}
//	
	//점수가 동일할 때 중복제거.
//	@Override
//	public int hashCode() {
//		return this.score;
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Student) {
//		Student that = (Student) obj;
//		return this.score == that.score;
//	}else {
//		return false;
//	}
//	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student that) {
		return this.score - that.score;	 // 음수값 : 오름차순, 양수값 : 내림차순
				
				
				
	}
}
