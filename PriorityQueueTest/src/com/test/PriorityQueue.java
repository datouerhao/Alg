package com.test;

public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;

	public PriorityQueue(int s) {
		maxSize = s;
		queueArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;
		if (nItems == 0)
			queueArray[nItems++] = item;
		else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queueArray[j])
					queueArray[j + 1] = queueArray[j];// ���ȶ��о��ǽ�����������棬С�����ַ�����
				else
					break;// �����������С�ڶ����е���ʱ����ѭ��
			}
			queueArray[j + 1] = item;// ��Ϊǰ��ȡ���Ǹ�j��queueArray[j]��ʱ�Ǵ���item�ģ�����Ҫ��item����queueArray[j+1]
			nItems++;
		}
	}

	public long remove() {
		int value = --nItems;
		return queueArray[value];

	}

	public long peekMin() {
		return queueArray[nItems - 1];
	}

	public long peekMax() {
		return queueArray[nItems = 0];
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public void display() {
		for (int j = nItems; j >= 0; j++) {
			System.out.print(j + " ");
		}
	}
}