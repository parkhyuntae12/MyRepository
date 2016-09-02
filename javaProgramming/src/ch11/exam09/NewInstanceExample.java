package ch11.exam09;

public class NewInstanceExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class clazz = Class.forName("ch11.exam09." + args[0]); //forname 객체가생성이안되도 입력된정보들을 로딩해준다
		// 어떤객체든 들어올수 있지만 사용방법이 같은(통일된 사용방법) 객체가 들어와야한다
		Object obj =clazz.newInstance(); //args[0]에 들어온정보로 객체를 만들어준다 디폴트 생성자가 있어야한다
		Action action = (Action) obj; //다형성 
		action.execute();
		
	}

}
