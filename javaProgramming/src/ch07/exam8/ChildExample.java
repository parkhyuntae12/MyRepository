package ch07.exam8;

public class ChildExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child child = new Child();
		child.method();
		child.method2();
		child.method3();
		
		System.out.println();
		
		Parent parent = child;
		parent.method();
		parent.method2();
	}

}
