package SecondLab;

import java.util.function.Consumer;

public class Tree {
    private static final DataNode[] array;
    private static       int        SPACE;

    static {
        array = new DataNode[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new DataNode(i + 1);
            array[i].label = ' ';
        }
        array[array.length - 1].name = -1;
        SPACE = 0;
    }

    private int root;

    public static void main(String[] args) {
        Tree tree1 = new Tree().create('A').create('C', new Tree().create('B'));
        Tree tree2 = new Tree().create('D').create('F', new Tree().create('E'));
        tree1.create('G', tree2);
//        Tree tree3 = new Tree().create('1').create('2').create('3');
        System.out.println(tree1);
        tree2.makeNull();
//        int parent = tree1.parent(6);
//        System.out.println(parent);
//        tree1.makeNull();
    }

    public Tree() {
        root = -1;
    }

    public int parent(int node) {
        checkRoot();
        return getParent(node, root);
    }

    private int getParent(int name, int root) {
        Node node = array[root].next;
        int parent = -1;
        while (node != null) {
            if (node.name == name) return root;
            parent = getParent(name, node.name);
            if (parent != -1) return parent;
            node = node.next;
        }
        return parent;
    }

    private void checkRoot() {
        if (root == -1) throw new NullPointerException();
    }

    public int leftMostChild(int node) {
        checkRoot();
        if (node == root && array[node].next != null) return array[node].next.name;
        if (node == root && array[node].next == null) throw new NullPointerException();
        if (getParent(node, root) == -1) throw new NullPointerException();
        return array[root].next.name;
    }

    public int rightSibling(int node) {
        checkRoot();
        int parent = getParent(node, root);
        if (parent == -1 || array[parent].next.next == null) throw new NullPointerException();
        return array[parent].next.next.name;
    }

    public char label(int node) {
        checkRoot();
        if (node == root) return array[root].label;
        int parent = getParent(node, root);
        if (parent == -1) throw new NullPointerException();
        return array[node].label;
    }

    public Tree create(char label) {
        if (SPACE == -1) return null;
        if (root != -1) array[SPACE].next = new Node(root, null);
        array[SPACE].label = label;
        root = SPACE;
        SPACE = array[SPACE].name;
        return this;
    }

    public Tree create(char label, Tree tree) {
        if (SPACE == -1) return null;
        if (root == -1) return tree.create(label);
        if (tree.root == -1) return create(label);
        array[SPACE].label = label;
        array[SPACE].next = new Node(root, new Node(tree.root, null));
        root = SPACE;
        SPACE = array[SPACE].name;
        return this;
    }

    public int root() {
        return root;
    }

    public void makeNull() {
        if (root == -1) return;
        makeNull(root);
        array[root].name = SPACE;
        array[root].label = ' ';
        array[root].next = null;
        root = -1;
    }

    private void makeNull(int root) {
        DataNode dataNode = array[root];
        Node node = dataNode.next;
        while (node != null) {
            if (array[node.name].next != null) makeNull(node.name);
            array[node.name].name = SPACE;
            array[node.name].label = ' ';
            array[node.name].next = null;
            SPACE = node.name;
            node = node.next;
        }
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append("[").append(i).append("] ").append(array[i].label);
            Node node = array[i].next;
            while (node != null) {
                sb.append(" -> [").append(node.name).append("]");
                node = node.next;
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private static class Node {
        public int  name;
        public Node next;

        public Node(int name, Node next) {
            this.name = name;
            this.next = next;
        }

        @Override public String toString() {
            return "Node{" + "name=" + name + ", next=" + next + '}';
        }
    }

    private static class DataNode {
        public int name;
        public Node next;
        public char label;

        DataNode(int name) {
            this.name = name;
        }

        @Override public String toString() {
            return "DataNode{" + "name=" + name + ", next=" + next + ", label=" + label + '}';
        }
    }
}
