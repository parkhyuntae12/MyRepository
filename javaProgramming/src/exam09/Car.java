package exam09;

public class Car {
	//Field
	int gas;
	
	
	//Constructor
	
	
	//Method
	void setGas(int gas){
		this.gas = gas;
	}
	
	boolean isLeftGas(){
		if(gas ==0){
			System.out.println("gas∞° æ¯Ω¿¥œ¥Ÿ.");
			return false;
		}else{
			System.out.println("gas∞° ¿÷Ω¿¥œ¥Ÿ.");
			return true;
		}
	}
	void run(){
		while(true){
			if(gas>0){
				System.out.println("∏ÿ√‰¥œ¥Ÿ.(gas ¿‹∑Æ :"+gas+")");
				gas -=1;//=gas--;
			}else{
				//break;
				System.out.println("∏ÿ√‰¥œ¥Ÿ.(gas ¿‹∑Æ :"+gas+")");
				return;
			}
		}
	}
	
	
	
}
