package ch11.exam06;

public class SystemTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
		int sum =0;
		for(int i =1; i<=1000000; i++){
			sum +=i;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(sum);
		System.out.println("걸린 시간은 : "+(end-start));
	}

}
