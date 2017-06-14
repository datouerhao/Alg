package com.test2;

public class Link {
	public int iData;
	public double dData;
	public Link next;

	public Link(int id, double dd) {
		iData = id;
		dData = dd;
	}

	public void display() {
		System.out.print("{" + iData + "," + dData + "}");
	}
}
