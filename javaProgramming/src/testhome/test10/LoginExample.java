package testhome.test10;

public class LoginExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			login("white","12345");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			login("blue","54321");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		public static void login(String id, String password) throws NotExistIDException, WrongPasswordException{
			//id가 blue가 아니라면 NotExistIDException 발생
			if(!id.equals("blue")){
				throw new NotExistIDException("아이디가 존재하지 않습니다.");
			}
			//password가 12345가 아니라면 wrongpasswordException발생
			if(!Password){
				throw new WrongPasswordException("패스워드가 틀립니다.");
	
			}
		}
	}
}
