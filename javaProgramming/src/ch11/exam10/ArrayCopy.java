package ch11.exam10;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr1 = {'J','A','V','A'};
		//硅凯汗荤 规过1
		char[] arr2 = new char[arr1.length];
		for(int i=0; i<arr1.length; i++){
			arr2[i]=arr1[i];
		}
		System.out.println(Arrays.toString(arr2));
		//规过2
		char[] arr3 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr3 , 0, arr1.length);
		System.out.println(Arrays.toString(arr3));
		
		//规过3
		char[] arr4 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr4));
	}
}