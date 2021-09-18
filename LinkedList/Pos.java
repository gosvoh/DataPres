package LinkedList;

import java.util.Objects;

public class Pos {
	private Node node;
	
	public Pos(Node node) {
		this.node = node;
	}
	
	public Node getPos() {
		return node;
	}
	
	public void setPos(Node node) {
		this.node = node;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pos)) return false;
		return node.equals(((Pos) o).getPos());
	}

	@Override public int hashCode() {
		return Objects.hash(node);
	}
}