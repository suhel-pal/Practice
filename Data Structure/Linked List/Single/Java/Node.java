package com.me.datastructure.linklist.single;

public class Node {
	
	private String data;
	private Node next;
	
	public Node() {}
	
	
	public Node(String data) {
		this.data = data;
		this.next = null;
	}


	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}


	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getLink() {
		return next;
	}
	public void setLink(Node next) {
		this.next = next;
	}

}
