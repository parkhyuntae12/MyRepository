package testhome.test04;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1,sum=0;
		for(i=1; i<100; i++){
			if(i%3==0){
				sum+=i;
			}
		}
		System.out.println("3의배수의합 : "+sum);
	}
}