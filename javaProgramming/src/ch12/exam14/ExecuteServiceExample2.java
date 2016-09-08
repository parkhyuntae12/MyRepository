package ch12.exam14;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPool 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//작업 생성
		for(int i=0;i<1000;i++){
			int count = i;
			Runnable task = new Runnable(){
				@Override
				public void run() {
					for(int i=0; i<10; i++){
						System.out.println("실행중...("+count +"):" +Thread.currentThread().getName());
					}
				}
			};
			//작업 큐에 작업넣기
			executorService.submit(task);
		}
		
		//스레드풀 종료
		executorService.shutdown();
	}
}