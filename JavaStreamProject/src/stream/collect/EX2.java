package stream.collect;


public class EX2 { 
enum Sex { MALE, FEMALE;}
enum City {Seoul, Pusan;
}
	String name;
	int age;
	 Sex gen;
	City city;
	public EX2(String name, int i, Sex gen, City city) {
		super();
		this.name = name;
		this.age = i;
		this.gen = gen;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Sex getGen() {
		return gen;
	}

	public void setGen(Sex gen) {
		this.gen = gen;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
}
