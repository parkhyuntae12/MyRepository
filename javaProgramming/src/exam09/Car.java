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
			System.out.println("gas�� �����ϴ�.");
			return false;
		}else{
			System.out.println("gas�� �ֽ��ϴ�.");
			return true;
		}
	}
	void run(){
		while(true){
			if(gas>0){
				System.out.println("����ϴ�.(gas �ܷ� :"+gas+")");
				gas -=1;//=gas--;
			}else{
				//break;
				System.out.println("����ϴ�.(gas �ܷ� :"+gas+")");
				return;
			}
		}
	}
	
	
	
}
