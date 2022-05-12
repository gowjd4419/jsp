package com.ict.datastructure;

public class NodeMain {

	public static void main(String[] args) {
		
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		n1.data = 100;
		n1.next = n2;
		n2.data = 200;
		n2.next = n3;
		n3.data = 300;
		n3.next = n4;
		n4.data = 400;
		n4.next = n5;
		n5.data = 500;
		n5.next = null;

		Node start = n1;
		System.out.println(start.next.next.data);

	}

}
