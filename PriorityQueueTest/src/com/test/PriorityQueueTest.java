package com.test;

import java.io.IOException;

public class PriorityQueueTest {
	public static void main(String[] args) throws IOException {
		PriorityQueue q = new PriorityQueue(5);
		q.insert(10);
		q.insert(50);
		q.insert(20);
		q.insert(40);
		q.insert(30);
		while (!q.isEmpty()) {
			long item = q.remove();
			System.out.print(item + " ");
		}
		q.display();
	}
}
