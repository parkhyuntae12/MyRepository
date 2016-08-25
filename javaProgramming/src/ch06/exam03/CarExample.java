package ch06.exam03;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car 변수선언
		Car myCar= null;
		//car 객체 생성하고 위치 정보 얻기
		try{
			 myCar=new Car();
		}catch(Exception e){} 
		//Car 객체가 있는지 조사
			if(myCar!=null){
				System.out.println("Car 객체 있음");
			}else{
				System.out.println("Car 객체 없음");
			}
			
			//객체 내부의 필드값을 읽어보자.
			System.out.println(myCar.company);
			//객체 내부의 필드값을 변경해보자.
			myCar.company = "KOSA";
			System.out.println(myCar.company);
			//객체 내부의 메소드를 호출해 보자.
			myCar.run();
	}

}
