package SecondLab;

public interface IQueue {
    void enqueue(char data);

    char dequeue();

    char front();

    void makeNull();

    boolean full();

    boolean empty();
}
