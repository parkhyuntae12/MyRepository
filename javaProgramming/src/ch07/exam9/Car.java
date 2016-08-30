package ch07.exam9;

public class Car {
//	Tire frontLeftTire = new Tire("앞왼쪽",6);
//	Tire frontRightTire = new Tire("앞오른쪽",2);
//	Tire backLeftTire = new Tire("뒤왼쪽",3);
//	Tire backRightTire = new Tire("뒤오른쪽",4);
	
	Tire[] tire = {
	                   new Tire("앞왼쪽",6),
	                   new Tire("앞오른쪽",2),
	                   new Tire("뒤왼쪽",3),
	                   new Tire("뒤오른쪽",4)
						};
	
	//생성자
	Car(){
		tire = new Tire[]{
				 new Tire("앞왼쪽",6),
                 new Tire("앞오른쪽",2),
                 new Tire("뒤왼쪽",3),
                 new Tire("뒤오른쪽",4)
		};
	}
	//메소드
	int run(){
		System.out.println("[자동차가 달립니다]");
//		if(frontLeftTire.roll()==false) {stop();  return 1; };
//		if(frontRightTire.roll()==false) {stop();  return 2; };
//		if(backLeftTire.roll()==false) {stop();  return 3; };
//		if(backRightTire.roll()==false) {stop();  return 4 ;};
//		return 0;
		for(int i=0; i<tire.length; i++){
			if(tire[i].roll()==false){
				stop();
				return(i+1);
			}
		}
		return 0;
	}
	
	void stop(){
		System.out.println("[자동차가 멈춥니다.]");
	}
}
