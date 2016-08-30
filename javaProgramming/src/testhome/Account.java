package testhome;

public class Account {
	private String ano;
	private String owner;
	private int  balance;
	
	
	public Account(String ano, String owner, int balance){
		this.ano =ano;
		this.owner=owner;
		this.balance=balance;
	}
	
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
}
