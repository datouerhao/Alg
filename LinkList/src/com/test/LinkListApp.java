package com.test;

public class LinkListApp {
	public static void main(String[] args) {
		LinkListTest list = new LinkListTest();
		list.insertFirst(22, 22.2);
		list.insertFirst(33, 33.3);
		list.insertFirst(44, 44.4);
		list.insertFirst(55, 55.5);
		list.displayList();
		while (!list.isEmpty()) {
			LinkList link = list.deleteFirst();
			System.out.print("deleted:");
			link.display();
			System.out.println("");
		}
		list.displayList();
	}
}
