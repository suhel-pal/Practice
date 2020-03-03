package com.me.datastructure.linklist.single;

public class SingleLinkList {

	private Node head;

	public SingleLinkList() {
		this.head = null;
	}

	public SingleLinkList(Node node) {
		if (node != null) {
			this.head.setData(node.getData());
			this.head.setLink(node.getLink());
		} else {
			throw new NullPointerException("Node used for initialize is null");
		}
	}

	public SingleLinkList(String data) {
		this.head = new Node(data);
	}

	public void addNode(String data) {
		if (this.head == null) {
			this.head = new Node(data);
		} else {
			Node temp = getLastNode();
			Node node = new Node(data);
			temp.setLink(node);
			temp = null;
			node = null;
		}

	}

	public void printElements() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.getData());
			temp = temp.getLink();
		}
		System.out.println();
	}

	private Node getLastNode() {
		Node temp = this.head;

		while (temp.getLink() != null) {
			temp = temp.getLink();
		}
		return temp;
	}

}
