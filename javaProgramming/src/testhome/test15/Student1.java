package testhome.test15;

public class Student1 {
	public int studentNum;
	public String name;
	
	public Student1(int studentNum, String name){
		this.studentNum=studentNum;
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student1)) return false;
			Student1 student = (Student1) obj;
		if(studentNum!=student.studentNum){
			return false;
		}
		return true;
		}
	@Override
	public int hashCode() {
		return studentNum;
	}
}