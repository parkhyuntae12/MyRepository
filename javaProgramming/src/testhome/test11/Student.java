package testhome.test11;

public class Student {
	private String StudentNum;
	
	public Student(String studentNum){
		this.StudentNum=StudentNum;
	}
	public String getStudentNum(){
		return StudentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
		return super.equals(obj);
		
		if(StudentNum.equals(studentNum.getStudentNum())){
			return true;
		}
		}
		return false;
	}
	@Override
	public int hashCode() {
	
		return StudentNum.hashCode();
	}
	
	
	
}
