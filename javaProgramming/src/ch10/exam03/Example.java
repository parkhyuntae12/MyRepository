package ch10.exam03;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.deposit(100);
		System.out.println(account.getBalance());
		
		try {
			account.withdraw(50);
			System.out.println("출금이 되었습니다.");
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();// 예외가 어디서부터 왔는지 경로추적
			System.out.println("출금이 되지 않아않아");
		}
	}

}
