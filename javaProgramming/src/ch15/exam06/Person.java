package ch15.exam06;

public class Person implements Comparable<Person>{//Person과 <Person> 의객체를 비교
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return name+"("+age+")";
	}
	@Override
	public int compareTo(Person target) {
		return (age-target.age);
	}
}