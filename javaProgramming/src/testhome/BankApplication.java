package testhome;

import java.util.Scanner;

public class BankApplication {
	private static Acount[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		while(run){
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("1.���»���"+"\t"+"2.���¸��"+"\t"+"3.����"+"\t"+"4.���"+"\t"+"5.����");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("����>");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo==1){
				createAccount();
			}else if(selectNo==2){
				accountList();
			}else if(selectNo==3){
				deposit();
			}else if(selectNo==4){
				withdraw();
			}else if(selectNo==5){
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}
	//���»����ϱ�
	private static void createAccount(){
		//�ۼ���ġ
	}
	//���¸�Ϻ���
	private static void accountList(){
		//�ۼ���ġ
	}
	//�����ϱ�
	private static void deposit(){
		
	}
	//����ϱ�
	private static void withdraw(){
		
	}
	//Acount�迭���� ano�� ������ Account ��ü ã��
	private static Account findAccount(String ano){
		
	}
}