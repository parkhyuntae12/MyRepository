package testhome.clone;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member ori = new Member("blue","ȫ�浿","12345",25,true);
		
		Member cloned = ori.getMember();
		cloned.password = "67890";
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println("id : "+cloned.id);
		System.out.println("name : "+cloned.name);
		System.out.println("password : "+cloned.password);
		System.out.println("age : "+cloned.age);
		System.out.println("adult : "+cloned.adult);
		
		System.out.println();
		
		System.out.println("[������ü�� �ʵ尪]");
		System.out.println("id : "+ori.id);
		System.out.println("name : "+ori.name);
		System.out.println("password : "+ori.password);
		System.out.println("age : "+ori.age);
		System.out.println("adult : "+ori.adult);
	}

}
