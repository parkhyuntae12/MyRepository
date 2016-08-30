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
			System.out.println("1.계좌생성"+"\t"+"2.계좌목록"+"\t"+"3.예금"+"\t"+"4.출금"+"\t"+"5.종료");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("선택>");
			
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
		System.out.println("프로그램 종료");
	}
	//계좌생성하기
	private static void createAccount(){
		//작성위치
	}
	//계좌목록보기
	private static void accountList(){
		//작성위치
	}
	//예금하기
	private static void deposit(){
		
	}
	//출금하기
	private static void withdraw(){
		
	}
	//Acount배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano){
		
	}
}