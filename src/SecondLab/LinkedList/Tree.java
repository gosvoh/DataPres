package SecondLab.LinkedList;

import SecondLab.ATree;

public class Tree extends ATree {
    private static int[] array;
    private static int pointer;
    private int root;

    static {
        array = new int[10];
        for (int i = 0; i < array.length; i++) array[i] = i;
        pointer = 0;
    }

    public Tree() {
        root = 0;
    }

    @Override public int parent(int node) {
        if (node == root) return node;
        return 0;
    }

    @Override public int leftMostChild(int node) {
        return 0;
    }

    @Override public int rightSibling(int node) {
        return 0;
    }

    @Override public int label(int node) {
        return 0;
    }

    @Override public ATree create(int... ints) {
        return null;
    }

    @Override public int root() {
        return root;
    }

    @Override public void makeNull() {
        root = 0;
    }
}
