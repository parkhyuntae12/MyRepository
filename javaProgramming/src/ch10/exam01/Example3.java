package ch10.exam01;

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{	
		String data1 = args[0];
			String data2 = args[1];
			
			int value = Integer.parseInt("data1");
			int value2 = Integer.parseInt("data2");
			
	
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("입력된 수가 틀립니다.");
	}catch (NumberFormatException e ){
		System.out.println("숫자를 입력하지 않았습니다.");
	}catch(Exception e){ // 모든예외를 포함하기 때문에 가장 위에있으면 안됨
		System.out.println("예외처리가 됨");
}
}
}