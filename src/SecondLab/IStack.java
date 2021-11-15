package SecondLab;

public interface IStack {
    void push(char data);

    char pop();

    char peek();

    void makeNull();

    boolean full();

    boolean empty();
}
