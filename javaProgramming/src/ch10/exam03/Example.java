package ch10.exam03;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.deposit(100);
		System.out.println(account.getBalance());
		
		try {
			account.withdraw(50);
			System.out.println("����� �Ǿ����ϴ�.");
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();// ���ܰ� ��𼭺��� �Դ��� �������
			System.out.println("����� ���� �ʾƾʾ�");
		}
	}

}
