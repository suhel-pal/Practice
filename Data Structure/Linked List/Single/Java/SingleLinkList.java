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

}
