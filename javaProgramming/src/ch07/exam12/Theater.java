package ch07.exam12;

public class Theater {
	public void check(Person person){
		if(person instanceof Adult){ //A instanceof B bŸ������ A�� �������
			Adult adult = (Adult) person;
			System.out.println("�ֹι�ȣ :"+adult.ssn);
		}
		if(person instanceof Student){
			Student student = (Student)person;
			System.out.println("�л���ȣ : "+student.sno );
		}
	}
}
