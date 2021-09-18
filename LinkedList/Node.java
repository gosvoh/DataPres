package LinkedList;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node {
    private final char[] name   = new char[20];
    private final char[] adress = new char[50];
    private       Node   next;

    public Node(char[] name, char[] adress) {
        System.arraycopy(name, 0, this.name, 0, name.length);
        System.arraycopy(adress, 0, this.adress, 0, adress.length);
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override public String toString() {
        return getStrFromChar(name) + ": " + getStrFromChar(adress);
    }

    private String getStrFromChar(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) if (c != 0) sb.append(c);
        return sb.toString();
    }

    private String getClearStr(String str) {
        return str.chars().filter(c -> c != 0).mapToObj(c -> {
            char ch = (char) c;
            return String.valueOf(ch);
        }).collect(Collectors.joining());
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Arrays.equals(name, node.name) && Arrays.equals(adress, node.adress) && Objects.equals(next, node.next);
    }

    @Override public int hashCode() {
        int result = Objects.hash(next);
        result = 31 * result + Arrays.hashCode(name);
        result = 31 * result + Arrays.hashCode(adress);
        return result;
    }
}