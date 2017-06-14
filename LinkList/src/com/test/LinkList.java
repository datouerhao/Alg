package com.test;

public class LinkList {
	public int iData;
	public double dData;
	public LinkList next;

	public LinkList(int id, double dd) {
		iData = id;
		dData = dd;
	}

	public void display() {
		System.out.print("{" + iData + "," + dData + "}");
	}
}
