package LinkedList;

import java.lang.NullPointerException;
import java.lang.StringBuilder;

public class List {
	private Node head;
	
	public List() {
		head = null;
	}
	
	public void insert(Pos pos, Node node) {
		if (pos.getPos() == null) head = node;
		else {
			Node prev = previous(pos).getPos();
			Node next = next(pos).getPos();
			prev.setNext(node);
			node.setNext(next);
		}
	}
	
	public Pos first() {
		return new Pos(head);
	}
	
	public Pos end() {
		Node node = head;
		while (node != null && node.getNext() != null) node = node.getNext();
		return new Pos(node);
	}
	
	public Pos locate(Node node) {
		Node n = head;
		while (n.equals(node)) n = n.getNext();
		return new Pos(n);
	}
	
	public Node retrieve(Pos pos) {
		checkPos(pos);
		Node node = head;
		while (!node.equals(pos.getPos())) node = node.getNext();
		return node;
	}
	
	public void delete(Pos pos) {
		Node node = previous(pos).getPos();
		node.setNext(node.getNext().getNext());
	}
	
	public Pos next(Pos pos) {
		checkPos(pos);
		return new Pos(pos.getPos().getNext());
	}

	public Pos previous(Pos pos) {
		checkPos(pos);
		Node node = head;
		while (node.hasNext() && node.getNext().equals(pos.getPos())) node = node.getNext();
		return new Pos(node);
	}
	
	public void makeNull() {
		head = null;
	}
	
	public void printList() {
		System.out.println(this);
	}
	
	private void checkPos(Pos pos) {
		if(pos == null || pos.getPos() == null) throw new NullPointerException("It's impossible to get object in empty position!");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = head;
		if (node == null) sb.append("List is empty!");
		while (node != null) {
			sb.append(node);
			if (node.hasNext()) sb.append(",").append(System.lineSeparator());
			node = node.getNext();
		}
		return sb.toString();
	}
}