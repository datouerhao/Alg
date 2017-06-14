package com.test;

public class LinkListTest {
	private LinkList first;

	public LinkListTest() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int id, double dd) {
		LinkList newLink = new LinkList(id, dd);
		newLink.next = first;
		first = newLink;
	}

	public LinkList deleteFirst() {
		LinkList temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.print("List (first-->last):");
		LinkList current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("");
	}

}
