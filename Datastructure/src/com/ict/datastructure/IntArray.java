package com.ict.datastructure;

import java.util.Arrays;

public class IntArray {
	static int count = 0;
	
	public static void addArr(int num, int[] arr) {
		if(count > 4) {
			System.out.println("데이터를 추가로 넣을 수 없습니다.");
		}else {
			arr[count] = num;
			count++;
		}
		System.out.println("현재 리스트 내에 자료가 " + count + "개 있습니다.");
	}
	// 데이터 빼는 메서드 removeArr();
	// 빼는 메서드를 실행하면 count-1 해서 하나 내리고 그 자리를 0으로 만든다.
	// count - 1 이 -1 이면 삭제할 데이터가 없습니다 라고 띄우고, count를 0인채로 유지한다.
	public static void removeArr(int[] arr) {
		if(count - 1 < 0) {
			System.out.println("삭제할 데이터가 더 없습니다.");
		}else {
			count--;
			arr[count] = 0;
			
		}
		System.out.println("현재 리스트 내에 자료가 " + count + "개 있습니다.");
	}
	
	// 내장된 데이터가 몊갠지 파악해주는 기능이 없다.
	// getArrLength(int[] arr); 를 이용해 배열이 몇개인지 콘솔에 띄워주도록 작성해주기.
	
	public static void getArrLength(int[] arr) {
		System.out.println("현재 리스트 내에 자료가 " + count + "개 있습니다.");
		System.out.println("count");
	}

	public static void main(String[] args) {
		int[] iArr = new int[5];
		System.out.println(Arrays.toString(iArr));
		addArr(10, iArr);
		addArr(3,iArr);
		addArr(4,iArr);
		addArr(5,iArr);
		addArr(6,iArr);
		addArr(6,iArr);
		System.out.println("----------------------");
		removeArr(iArr);
		removeArr(iArr);
		removeArr(iArr);
		removeArr(iArr);
		removeArr(iArr);
		removeArr(iArr);
		
		System.out.println(Arrays.toString(iArr));
		System.out.println(iArr.length);
		}

}
