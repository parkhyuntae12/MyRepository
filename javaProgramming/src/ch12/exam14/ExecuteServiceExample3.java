package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadPool ����
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//�۾� ����
		for(int i=0;i<10;i++){
			int count = i;
			Runnable task = new Runnable(){
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					System.out.println("�������� �� ��: "+threadPoolExecutor.getPoolSize());//������Ǯ�ȿ��ִ� �����尡 ����� �������
					System.out.println("����("+count +"):" +Thread.currentThread().getName());
					int value = Integer.parseInt("aa");//NumberFormatException �߻�
					}
			};
			//�۾� ť�� �۾��ֱ�
			executorService.submit(task);  //
			//executorService.execute(task);
		}
		
		//������Ǯ ����
		executorService.shutdown();
	}
}