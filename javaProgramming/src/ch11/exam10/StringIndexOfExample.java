package ch11.exam10;

public class StringIndexOfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String subject = " �ڹ� ���α׷���";
		boolean result1 = subject.contains("�ڹ�");
		if(result1){
		System.out.println("�ڹٰ��� å�̱���");
		}else{
			System.out.println("�ڹ� ���þ��� å�̱���");
		}
		
		int result2 = subject.indexOf("�ڹ�");
		if(result2!=-1){
		System.out.println("�ڹٰ��� å�̱���");
		}else{
			System.out.println("�ڹ� ���þ��� å�̱���");
		}
		int startIndex= subject.indexOf("�ڹ�");
		int endIndex = startIndex+2;
		//String token1 = subject.substring(subject.indexOf("�ڹ�"),2);//substring ���ڸ� 0��°���� 2���ڸ��ٴ�
		String token1 = subject.substring(startIndex, endIndex);															  //substring�� �������������� 	
		System.out.println(token1);
	
		String find ="���α׷���";
		startIndex =  subject.indexOf("���α׷���");
		//endIndex = startIndex+find.length();
		//String token2 = subject.substring(startIndex, endIndex);
		String token2 = subject.substring(startIndex);
		System.out.println(token2);
	}
}