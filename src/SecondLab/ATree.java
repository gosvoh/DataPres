package SecondLab;

public abstract class ATree {
    public abstract int parent(int node);

    public abstract int leftMostChild(int node);

    public abstract int rightSibling(int node);

    public abstract int label(int node);

    public abstract ATree create(int... nodes);

    public abstract int root();

    public abstract void makeNull();
}
