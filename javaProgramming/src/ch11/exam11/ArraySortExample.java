package ch11.exam11;

import java.util.Arrays;

public class ArraySortExample {
	public static void main(String[] args){
		Board[] boardArr = {
		new Board(3,"������ ȭ����"),
		new Board(1,"�����ִ� �߼�"),
		new Board(5,"������ ������?")
		};
		
		Arrays.sort(boardArr);
		System.out.println(Arrays.toString(boardArr));
	}
}
