package testhome.test10;

public class LoginExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			login("write", "12345");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			login("blue", "54321");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException{
		if(id.equals("blue")){
			throw new NotExistIDException("아이디 존재x");
		}
		if(password.equals("12345")){
			throw new NotExistIDException("아이디 존재x");
		}
	}
}