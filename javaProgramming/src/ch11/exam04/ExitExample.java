package ch11.exam04;

public class ExitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setSecurityManager(new SecurityManager(){
		@Override
			public void checkExit(int status) {
			if(status !=5){
			throw new SecurityException();//��Ÿ�ӿ���
		    }	
			System.out.println("�� �׳�~");
		}
		}); 
		//��ť��Ƽ �Ŵ��� : �ڹٿ��� ���α׷��� �����Ű
		
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				System.exit(i);
			}catch(SecurityException e){}
			
			//if(i==5){
				//System.exit(i);���α׷��� �����϶� ()�ȿ� ����̵��� ���ᰡ�ȴ� 
								  //������ Ư�����ڸ� �־ �׶��� �����Ű�������
				//break; ���߰� ������ �������Ͷ�
				//return;�޼ҵ带 ������������
			//}	
		}
	}
}
