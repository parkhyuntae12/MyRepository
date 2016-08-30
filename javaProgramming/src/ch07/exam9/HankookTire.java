package ch07.exam9;

public class HankookTire extends Tire{
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	@Override//컴파일러에게 검사를 맡기는것
	public boolean roll(){
		++accmulatedRotation;
		if(accmulatedRotation<maxRotation){
			System.out.println(location + "HanKookTire 수명 : "+(maxRotation-accmulatedRotation)+"회");
			return true;
		}else{
			System.out.println("***"+location +"HanKookTire 펑크 ***" );
			return false;
		}
	}
}
