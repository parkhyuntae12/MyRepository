package testhome.test06;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run= true;
		while(run){
			System.out.println("-------------------------------------------");
			System.out.println("1.���»���|2.���¸��|3.����|4.���|5.����");
			System.out.println("-------------------------------------------");
			System.out.println("����>");
		
			int selectNo = scanner.nextInt();
			
			if(selectNo==1){
				createAccount1();
			}else if(selectNo==2){
				accountList();
			}else if(selectNo==3){
				deposit();
			}else if(selectNo==4){
				withdraw();
			}else if(selectNo==5){
				run=false;
			}
		}
		System.out.println("���α׷� ����");
		
		
		//���»����ϱ�
		private static void createAccount(){
			System.out.println("--------");
			System.out.println("���»���");
			System.out.println("--------");
			
			System.out.println("���¹�ȣ : ");
			String ano = scanner.next();
			System.out.println("������ : ");
			String owner = scanner.next();
			System.out.println("�ʱ� �Աݾ� : ");
			int balance= scanner.nextInt();
	
			Account newAccount = new Account(ano, owner, balance);
			for(int i=0;i<accountArray.length;i++){
				if(accountArray[i]==null){
					accountArray[i]=newAccount;
					System.out.println("��� : "+"���°� �����Ǿ����ϴ�.");
					break;
				}
			}
		}
		//���¸�Ϻ���
		private static void accountList(){
			System.out.println("--------");
			System.out.println("���¸��");
			System.out.println("--------");	
			for(int i=0;i<accountArray.length;i++){
				Account account = accountArray[i];
				if(accountArray[i]!=null){
					System.out.println(account.getAno());
					System.out.println("    ");
					System.out.println(account.getOwner());
					System.out.println("    ");
					System.out.println(account.getBalance());
					System.out.println();
				}
			}
		}
		//�����ϱ�
		private static void deposit(){
			System.out.println("--------");
			System.out.println("����");
			System.out.println("--------");			
		}
		//����ϱ�
		private static void withdraw(){
			System.out.println("--------");
			System.out.println("���");
			System.out.println("--------");			
		}
		private static Account findAccount(String ano){
			
		}
	}

	private static void accountList() {
		// TODO Auto-generated method stub
		
	}

	private static void createAccount1() {
		// TODO Auto-generated method stub
		
	}
}