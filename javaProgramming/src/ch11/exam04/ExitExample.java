package ch11.exam04;

public class ExitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setSecurityManager(new SecurityManager(){
		@Override
			public void checkExit(int status) {
			if(status !=5){
			throw new SecurityException();//런타임예외
		    }	
			System.out.println("나 죽네~");
		}
		}); 
		//시큐리티 매니저 : 자바에서 프로그램을 종료시키
		
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				System.exit(i);
			}catch(SecurityException e){}
			
			//if(i==5){
				//System.exit(i);프로그램을 종료하라 ()안에 어떤값이들어가도 종료가된다 
								  //하지만 특정숫자를 넣어서 그때만 종료시키고싶으면
				//break; 멈추고 밖으로 빠져나와라
				//return;메소드를 실행하지마라
			//}	
		}
	}
}
