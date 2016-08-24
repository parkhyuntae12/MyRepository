package ch06.exam07;

public class Car {
	//Field
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	//Constructor
	Car(){
		
	}
	Car(String model){
		this(model,"은색",250);
	}
	Car(String model,String color){
		this(model,color,250);
	}
	Car(String model, String color, int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	//Method
}