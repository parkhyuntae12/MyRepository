package ch07.exam1;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car(); //객체를 생성하면 1.부모 2.자식순으로 객체가생성
		car.kind="승용차";
		car.maker="현대자동차";
		
		
		Car car2 = new Car();//한번더 객체가 생성되면 다시 부모와자식이  객체가 생성된다
		car2.kind="트럭";
		car2.maker="기아자동차";
		/*
		car.powerOn();
		car.powerOff();
		
		car2.powerOn();
		car2.powerOff();*/
	}
}