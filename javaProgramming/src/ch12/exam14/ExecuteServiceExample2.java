package ch12.exam14;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPool ����
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//�۾� ����
		for(int i=0;i<1000;i++){
			int count = i;
			Runnable task = new Runnable(){
				@Override
				public void run() {
					for(int i=0; i<10; i++){
						System.out.println("������...("+count +"):" +Thread.currentThread().getName());
					}
				}
			};
			//�۾� ť�� �۾��ֱ�
			executorService.submit(task);
		}
		
		//������Ǯ ����
		executorService.shutdown();
	}
}