package ch11.exam05;

public class Employee {
	private int eno;
	
	public Employee(int eno){
		this.eno = eno;
		System.out.println("Employee(" + eno + ")�� �޸𸮿� ������");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee(" + eno + ")�� �޸𸮿� ���ŵ�");
	}
}
