package testhome;

import java.util.Scanner;

public class TestExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String [][] allstu = new String[100][];
		Test test = null;
		
		
		while(true){
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1. ��� | 2. �۾��� | 3. �� ���� | 4. ���� | 5. ���� | 6. ����");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("���� : ");
			
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){ // ����� ����������
				System.out.println("���л� �� : ");
				
				boolean allstus = false; //���� ������ ��,������ ����
				for(String[] allstus1: allstu){
					if(allstus1 !=null){
						allstus =true;
					} 
				} 
				if(allstus){
					System.out.println("����Ǿ��ִ� ���� �����ϴ�.");
					continue;
				}
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for(String[] all : allstu){
					if(all !=null)
						System.out.println(all[0]+"\t"+all[1]+ "\t" + all[2] + "\t   " + all[3]);
				}
				System.out.println("***************************************");
				System.out.println();
			}else if(choice.equals("2")){
				System.out.print("������ �Է��ϼ��� : ");
				String title = scanner.nextLine();
				System.out.print("������ �Է��ϼ���(�� �ٸ� ����) : ");
				String content = scanner.nextLine();
				System.out.print("�۾��̸� �Է��ϼ��� : ");
				String writer = scanner.nextLine();
				
				for(int i=0; i<allstu.length;i++){
					if(allstu[i] == null){
						String[]all ={String.valueOf(i),title,writer, "0", content };
						allstu[i] =all;
						break;
					}
				}
			}else if ( choice.equals("3") ) { 
				boolean allstuIs = false;
				for ( String[] noallstu : allstu ) {
					if ( noallstu != null ) {
						allstuIs = true;
					}
				}

				if( allstuIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}
				
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("�ڼ��� �� ���� ��ȣ�� �Է��ϼ��� : ");
					boolean detail = false;
					
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� �ش��ϴ� ���� �����ϴ�. " );
					} else {
						allstu[num][3] = String.valueOf( 1 + Integer.parseInt(allstu[num][3]) );

						System.out.println("��ȣ : " + allstu[num][0]);
						System.out.println("���� : " + allstu[num][1]);
						System.out.println("�۾��� : " + allstu[num][2]);
						System.out.println("��ȸ�� : " + allstu[num][3]);
						System.out.println("���� : ");
						System.out.println(allstu[num][4] + "\n");
					}
					
					break;
				}
				
			} else if ( choice.equals("4") ) {
				boolean allstuIs = false;
				
				for ( String[] noallstuIs : allstu ) {
					if ( noallstuIs != null ) {
						allstuIs = true;
					}
				}
				
				if( allstuIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}

				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("������ ���� ��ȣ�� �Է��ϼ��� : ");
					
					boolean detail = false;
					
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� ���� �����ϴ�.");
					} else {
						while ( true ) {
							System.out.print("������ �κ��� �����ϼ��� (1. ���� | 2. ���� | 3. ���) : " );
							int modNum = Integer.parseInt(scanner.nextLine());
							
							if ( modNum == 3 ) {
								break;
							} else if ( modNum == 1 ) {
								System.out.println("���� ������ \"" + allstu[num][modNum] + "\"�Դϴ�.");
								System.out.print("������ ������ �Է� �ϼ��� : ");
								allstu[num][modNum] = scanner.nextLine();
								System.out.println("�����Ǿ����ϴ�. ");
								break;
							} else if ( modNum == 2 ) {
								System.out.println("���� ������ \"" + allstu[num][modNum+2] + "\"�Դϴ�.");
								System.out.print("������ ������ �Է� �ϼ��� : ");
								allstu[num][modNum+2] = scanner.nextLine();
								System.out.println("�����Ǿ����ϴ�. ");
								break;
							} else {
								System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~3 ������ ���ڸ� �Է��� �ּ���.");
							}
						}
							
					}
					
					break;	
				}
							
			} else if ( choice.equals("5") ) {
				
				boolean allstuIs = false;
				
				for ( String[] noallstu : allstu ) {
					if ( noallstu != null ) {
						allstuIs = true;
					}
				}
				
				if( allstuIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}
				
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("������ ���� ��ȣ�� �Է��ϼ��� : ");
					boolean detail = false;
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� ���� �����ϴ�.");
					} else {
						allstu[num] = null;
						System.out.println("���� �Ǿ����ϴ� ");
					}
					
					break;	
				}			
				
			} else if ( choice.equals("6") ) {
				System.out.println("���α׷��� �����մϴ�. " );
				break;
				
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~6 ������ ���ڸ� �Է��ϼ��� \n");
		}
	}
}
}