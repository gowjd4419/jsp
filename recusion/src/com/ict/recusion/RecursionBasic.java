package com.ict.recusion;

public class RecursionBasic {
	
	public static void recursive(int num) {
		
		if(num < 1) {
			System.out.println("재귀호출 끝!");
			return;
		}
		System.out.println("recursive : " + num);
		recursive(num - 1);
		}

	public static void main(String[] args) {
		recursive(3);
	}

}
