package FirstLab.ArrayList;

import FirstLab.INode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Node implements INode {
    private final char[] name    = new char[20];
    private final char[] address = new char[50];

    public Node(char[] name, char[] address) {
        System.arraycopy(name, 0, this.name, 0, name.length);
        System.arraycopy(address, 0, this.address, 0, address.length);
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

    @Override public char[] getName() {
        return name;
    }

    @Override public void setName(char[] name) {
        System.arraycopy(name, 0, this.name, 0, name.length);
    }

    @Override public char[] getAddress() {
        return address;
    }

    @Override public void setAddress(char[] address) {
        System.arraycopy(address, 0, this.address, 0, address.length);
    }

    @Override public String toString() {
        return "Name: " + getStrFromChar(name) + ", address: " + getStrFromChar(address);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Arrays.equals(name, node.name) && Arrays.equals(address, node.address);
    }

    @Override public int hashCode() {
        int result = Arrays.hashCode(name);
        result = 31 * result + Arrays.hashCode(address);
        return result;
    }
}
