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
			System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세 보기 | 4. 수정 | 5. 삭제 | 6. 종료");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("선택 : ");
			
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){ // 목록을 선택했을때
				System.out.println("총학생 수 : ");
				
				boolean allstus = false; //글이 있으면 참,없으면 거짓
				for(String[] allstus1: allstu){
					if(allstus1 !=null){
						allstus =true;
					} 
				} 
				if(allstus){
					System.out.println("저장되어있는 글이 없습니다.");
					continue;
				}
				System.out.println("***************************************");
				System.out.println("번호\t제목\t글쓴이\t조회수");
				System.out.println("***************************************");
				
				for(String[] all : allstu){
					if(all !=null)
						System.out.println(all[0]+"\t"+all[1]+ "\t" + all[2] + "\t   " + all[3]);
				}
				System.out.println("***************************************");
				System.out.println();
			}else if(choice.equals("2")){
				System.out.print("제목을 입력하세요 : ");
				String title = scanner.nextLine();
				System.out.print("내용을 입력하세요(한 줄만 가능) : ");
				String content = scanner.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
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
					System.out.println("저장되어있는 글이 없습니다. ");
					continue;
				}
				
				System.out.println("***************************************");
				System.out.println("번호\t제목\t글쓴이\t조회수");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("자세히 볼 글의 번호를 입력하세요 : ");
					boolean detail = false;
					
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** 잘못 입력하셨습니다 ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("입력하신 번호에 해당하는 글이 없습니다. " );
					} else {
						allstu[num][3] = String.valueOf( 1 + Integer.parseInt(allstu[num][3]) );

						System.out.println("번호 : " + allstu[num][0]);
						System.out.println("제목 : " + allstu[num][1]);
						System.out.println("글쓴이 : " + allstu[num][2]);
						System.out.println("조회수 : " + allstu[num][3]);
						System.out.println("내용 : ");
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
					System.out.println("저장되어있는 글이 없습니다. ");
					continue;
				}

				System.out.println("***************************************");
				System.out.println("번호\t제목\t글쓴이\t조회수");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("수정할 글의 번호를 입력하세요 : ");
					
					boolean detail = false;
					
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** 잘못 입력하셨습니다 ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("입력하신 번호의 글이 없습니다.");
					} else {
						while ( true ) {
							System.out.print("수정할 부분을 선택하세요 (1. 제목 | 2. 내용 | 3. 취소) : " );
							int modNum = Integer.parseInt(scanner.nextLine());
							
							if ( modNum == 3 ) {
								break;
							} else if ( modNum == 1 ) {
								System.out.println("현재 제목은 \"" + allstu[num][modNum] + "\"입니다.");
								System.out.print("수정할 제목을 입력 하세요 : ");
								allstu[num][modNum] = scanner.nextLine();
								System.out.println("수정되었습니다. ");
								break;
							} else if ( modNum == 2 ) {
								System.out.println("현재 내용은 \"" + allstu[num][modNum+2] + "\"입니다.");
								System.out.print("수정할 내용을 입력 하세요 : ");
								allstu[num][modNum+2] = scanner.nextLine();
								System.out.println("수정되었습니다. ");
								break;
							} else {
								System.out.println("잘못 입력하셨습니다. 1~3 사이의 숫자를 입력해 주세요.");
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
					System.out.println("저장되어있는 글이 없습니다. ");
					continue;
				}
				
				System.out.println("***************************************");
				System.out.println("번호\t제목\t글쓴이\t조회수");
				System.out.println("***************************************");
				
				for ( String[] all : allstu ) {
					if ( all != null )
						System.out.println(all[0] + "\t" + all[1] + "\t" + all[2] + "\t   " + all[3]);
				}
				
				System.out.println("***************************************");
				System.out.println();
				
				while ( true ) {
					System.out.print("삭제할 글의 번호를 입력하세요 : ");
					boolean detail = false;
					String intException = scanner.nextLine();
					for ( int i = 0 ; i < 100 ; i++ ) {
						if ( intException.equals(String.valueOf(i)) ) {
							detail = true;
							break;
						}
					}
					
					if ( detail == false ) {
						System.out.println(" ** 잘못 입력하셨습니다 ** ");
						continue;
					}
					
					int num = Integer.parseInt(intException);
					
					if ( allstu[num] == null ) {
						System.out.println("입력하신 번호의 글이 없습니다.");
					} else {
						allstu[num] = null;
						System.out.println("삭제 되었습니다 ");
					}
					
					break;	
				}			
				
			} else if ( choice.equals("6") ) {
				System.out.println("프로그램을 종료합니다. " );
				break;
				
			} else {
				System.out.println("잘못 입력하셨습니다. 1~6 사이의 숫자를 입력하세요 \n");
		}
	}
}
}