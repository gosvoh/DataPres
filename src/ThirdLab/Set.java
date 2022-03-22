package ThirdLab;

public interface Set {
    Set union(Set otherSet);

    Set intersection(Set otherSet);

    Set difference(Set otherSet);

    void insert(int element);

    void delete(int element);

    void assign(Set otherSet);

    int min();

    int getMinRange();

    int max();

    int getMaxRange();

    boolean equals(Object obj);

    void makeNull();

    boolean contains(int element);

    Set merge(Set otherSet);

    Set find(Set otherSet, int element);
}
