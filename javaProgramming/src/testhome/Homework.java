package testhome;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Article[] article = new Article[100];
		Article art1 = new Article();
		
		while ( true ) {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1. ��� | 2. �۾��� | 3. �� ���� | 4. ���� | 5. ���� | 6. ����");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("���� : ");
			
			String choice = scanner.nextLine();
			
			if ( choice.equals("1") ) {
				// 1. ��� �� �������� �� ����Ǵ� �κ�
				// ��ȣ  ����  �۾���  ��ȸ�� 
				// �� ǥ���ϴ� ����� ��Ÿ����.
				
				// �Էµ� ���� �ִ��� Ȯ��. ������ true ������ false
				boolean articleIs = false;
				
				// ��Ͽ� ���� ������ contentIs�� false�� �ǰ� ������ true�� �ȴ�.
				for ( Article noArticle : article ) {
					if ( noArticle != null ) {
						articleIs = true;
					}
				}
				
				// �Էµ� ���� ���� �� ������ �������� �ʰ�, continue�� �����ؼ� while�� ó������ ���ư���.
				if( articleIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}
				 
				// �Էµ� ���� ������ �Ʒ��� �����Ѵ�.
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( Article art : article ) {
					if ( art != null )
						System.out.println(art1.getNo() + "\t" + art1.getTitle() + "\t" + art1.getWriter() + "\t   " + art1.getHit());
				}

				System.out.println("***************************************");
				System.out.println();
				
			} else if ( choice.equals("2") ){
				// 2. �۾��� �� �������� �� ����Ǵ� �κ�
				
				System.out.print("������ �Է��ϼ��� : ");
				String title = scanner.nextLine();
				System.out.print("������ �Է��ϼ���(�� �ٸ� ����) : ");
				String content = scanner.nextLine();
				System.out.print("�۾��̸� �Է��ϼ��� : ");
				String writer = scanner.nextLine();
				
				// ����ִ� �迭�� ã�Ƽ� ��ȣ, ����, �۾���, ��ȸ��(0), ������ �Է��Ѵ�.
				for ( int i = 0 ; i < article.length ; i++ ) {
					if( article[i] == null ) {
						article[i] = new Article(i, title, writer, 0, content);
						break;
					}
				}
				
			} else if ( choice.equals("3") ) {
				// 3. �󼼺��� �� �������� �� ����Ǵ� �κ�
				
				// �Էµ� ���� �ִ��� Ȯ��. ������ true ������ false
				boolean articleIs = false;
				
				// ��Ͽ� ���� ������ contentIs�� false�� �ǰ� ������ true�� �ȴ�.
				for ( Article noArticle : article ) {
					if ( noArticle != null ) {
						articleIs = true;
					}
				}
				
				// �Էµ� ���� ���� �� ������ �������� �ʰ�, continue�� �����ؼ� while�� ó������ ���ư���.
				if( articleIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}
				
				// �Էµ� ���� ���� �� ���
				// ���� ���� ����� �����ش�.
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( Article art : article ) {
					if ( art != null )
						System.out.println(art.getNo() + "\t" + art.getTitle() + "\t" + art.getWriter() + "\t   " + art.getHit());
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					// ���ϰ� �� ���� ��ȣ�� �Է� �޴´�.
					System.out.print("�ڼ��� �� ���� ��ȣ�� �Է��ϼ��� : ");
					
					// ���ڰ� �ԷµǾ��� ���� ���� ó�� ����
					boolean excBool = false;
					
					// �Էµ� ���� 0~99 ������ ���̸� excBool�� true�� �ȴ�.
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							excBool = true;
							break;
						}
					}
					
					// �Էµ� ���� 0~99 ������ ���ڰ� �ƴϸ� �����޼����� ���� �ݺ����� ó������ ���ư���.
					if ( excBool == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					// �Է��� ��ȣ�� �ش��ϴ� ���� ������ ���� �޼��� ���
					// ������ ��ȣ, ����, �۾���, ��ȸ��, ���� ���. �� ��ȸ�� 1 ����.
					if ( article[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� �ش��ϴ� ���� �����ϴ�. " );
					} else {
						// ��ȸ�� 1 ����
						article[num].hit++;

						// ��ȣ, ����, �۾���, ��ȸ��, ���� ���
						System.out.println("��ȣ : " + article[num].getNo());
						System.out.println("���� : " + article[num].getTitle());
						System.out.println("�۾��� : " + article[num].getWriter());
						System.out.println("��ȸ�� : " + article[num].getHit());
						System.out.println("���� : ");
						System.out.println(article[num].getContent() + "\n");
					}
					
					break;
				}
				
			} else if ( choice.equals("4") ) {
				// 4. ���� �� �������� �� ����Ǵ� �κ�.
				
				// �Էµ� ���� �ִ��� Ȯ��. ������ true ������ false
				boolean articleIs = false;
				
				// ��Ͽ� ���� ������ contentIs�� false�� �ǰ� ������ true�� �ȴ�.
				for ( Article noArticle : article ) {
					if ( noArticle != null ) {
						articleIs = true;
					}
				}
				
				// �Էµ� ���� ���� �� ������ �������� �ʰ�, continue�� �����ؼ� while�� ó������ ���ư���.
				if( articleIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}

				// �Էµ� ���� ���� �� ���
				// ���� ���� ����� �����ش�.
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( Article art : article ) {
					if ( art != null )
						System.out.println(art.getNo() + "\t" + art.getTitle() + "\t" + art.getWriter() + "\t   " + art.getHit());
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					// ������ ���� ��ȣ�� �Է� �޴´�.
					System.out.print("������ ���� ��ȣ�� �Է��ϼ��� : ");
					
					// ���ڰ� �ԷµǾ��� ���� ���� ó�� ����
					boolean excBool = false;
					
					// �Էµ� ���� 0~99 ������ ���̸� excBool�� true�� �ȴ�.
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							excBool = true;
							break;
						}
					}
					
					// �Էµ� ���� 0~99 ������ ���ڰ� �ƴϸ� �����޼����� ���� �ݺ����� ó������ ���ư���.
					if ( excBool == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					// �Էµ� ��ȣ�� ��ġ�ϴ� ���� ���� ���(if), �� ��ġ�ϴ� ���� �ִ� ���(else)
					if ( article[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� ���� �����ϴ�.");
					} else {
						while ( true ) {
							System.out.print("������ �κ��� �����ϼ��� (1. ���� | 2. ���� | 3. ���) : " );
							int modNum = Integer.parseInt(scanner.nextLine());
							
							if ( modNum == 3 ) {
								break;
							} else if ( modNum == 1 ) {
								System.out.println("���� ������ \"" + article[num].getTitle() + "\"�Դϴ�.");
								System.out.print("������ ������ �Է� �ϼ��� : ");
								article[num].title = scanner.nextLine();
								System.out.println("�����Ǿ����ϴ�. ");
								break;
							} else if ( modNum == 2 ) {
								System.out.println("���� ������ \"" + article[num].getContent() + "\"�Դϴ�.");
								System.out.print("������ ������ �Է� �ϼ��� : ");
								article[num].content = scanner.nextLine();
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
				// 5. ���� �� �������� �� ����Ǵ� �κ�
				
				// �Էµ� ���� �ִ��� Ȯ��. ������ true ������ false
				boolean articleIs = false;
				
				// ��Ͽ� ���� ������ contentIs�� false�� �ǰ� ������ true�� �ȴ�.
				for ( Article noArticle : article ) {
					if ( noArticle != null ) {
						articleIs = true;
					}
				}
				
				// �Էµ� ���� ���� �� ������ �������� �ʰ�, continue�� �����ؼ� while�� ó������ ���ư���.
				if( articleIs == false ) {
					System.out.println("����Ǿ��ִ� ���� �����ϴ�. ");
					continue;
				}
				
				// �Էµ� ���� ���� �� ���
				// ���� ���� ����� �����ش�.
				System.out.println("***************************************");
				System.out.println("��ȣ\t����\t�۾���\t��ȸ��");
				System.out.println("***************************************");
				
				for ( Article art : article ) {
					if ( art != null )
						System.out.println(art.getNo() + "\t" + art.getTitle() + "\t" + art.getWriter() + "\t   " + art.getHit());
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					// ������ ���� ��ȣ�� �Է� �޴´�
					System.out.print("������ ���� ��ȣ�� �Է��ϼ��� : ");
					
					// ���ڰ� �ԷµǾ��� ���� ���� ó�� ����
					boolean excBool = false;
					
					// �Էµ� ���� 0~99 ������ ���̸� excBool�� true�� �ȴ�.
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							excBool = true;
							break;
						}
					}
					
					// �Էµ� ���� 0~99 ������ ���ڰ� �ƴϸ� �����޼����� ���� �ݺ����� ó������ ���ư���.
					if ( excBool == false ) {
						System.out.println(" ** �߸� �Է��ϼ̽��ϴ� ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					// �Էµ� ��ȣ�� ��ġ�ϴ� ���� ���� ���(if), �� ��ġ�ϴ� ���� �ִ� ���(else)
					if ( article[num] == null ) {
						System.out.println("�Է��Ͻ� ��ȣ�� ���� �����ϴ�.");
					} else {
						article[num] = null;
						System.out.println("���� �Ǿ����ϴ� ");
					}
					
					break;	
				}			
				
			} else if ( choice.equals("6") ) {
				// 6. ���� �� �Է� ������ ���α׷� ���� �޼����� ��� �� ���α׷��� �����Ѵ�.
				System.out.println("���α׷��� �����մϴ�. " );
				break;
				
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~6 ������ ���ڸ� �Է��ϼ��� \n");
			}
		}		
	}

}
