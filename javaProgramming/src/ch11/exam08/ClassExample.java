package ch11.exam08;

public class ClassExample {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//Class classCar = Car.class; 
		//Class classCar = Class.forName("Ch11.exam08.Car");
		Car car =new Car();
		Class classCar = car.getClass();
		
		System.out.println(classCar.getName());
		System.out.println(classCar.getSimpleName());
		System.out.println(classCar.getPackage().getName());
	}
}
