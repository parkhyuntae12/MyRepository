package ch15.exam07;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Message> queue = new LinkedList<>();
		
		queue.offer(new Message("sendMail","ȫ�浿"));
		queue.offer(new Message("sendSMS","���ڹ�"));
		queue.offer(new Message("sendKakaotalk","ȫ�β�"));
		
		while(!queue.isEmpty()){
			Message message = queue.poll();
			switch(message.command){
			case "sendMail":
				System.out.println(message.to+"�Կ��� ������ �����ϴ�.");
				break;
			case "sendSMS":
				System.out.println(message.to+"�Կ��� SMS�� �����ϴ�.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to+"�Կ��� īī������ �����ϴ�.");
				break;
			}
		}
	}
}