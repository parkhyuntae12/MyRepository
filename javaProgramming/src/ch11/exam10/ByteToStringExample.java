package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,6,4);// bytes Ÿ�Թ迭�� 6��°�ε������� 4��(����Ʈ�ǰ���)
		System.out.println(str2);*/
		
		//--------------------------------------------------------------
		String str3="ȫ�浿";//�ѱ��� �ƽ�Ű�ڵ�� ǥ���Ҽ����� 
		byte[] strBytes3 = str3.getBytes(); 
		
		String str4 = new String(strBytes3);//�ѹ��ڴ� 2����Ʈ �����ڵ�� �аڴ�
		System.out.println(str4);
		
		String str5 = "ȫ�浿";
		 byte[] strBytes5 = str5.getBytes("UTF-8");//UTF-8=�ѹ��ڴ� 3����Ʈ
		                                                       //�ѹ��ڴ� 3����Ʈ�� �迭�� UTF-8���аٴ�
		 													   //=(���ڵ�)
		 String str6 = new String(strBytes5,"UTF-8");//utf-8���ڼ����� ���� �迭�� �ٽ� utf-8�κ����ؼ�
		                                                          //�аڴ�.(=���ڵ�)
		 System.out.println(str6);
		 
		 String str7 = "abȫ�浿";
		 byte[] strBytes6 = str7.getBytes("EUC-KR");
		 String str8 = new String(strBytes6,"EUC-KR");
		 System.out.println(str8);
		 String str9 = new String(strBytes6,0,4,"EUC-KR"); //0��°�ε������� 4��°�̸�!�ε�������
		 System.out.println(str9);
}
}