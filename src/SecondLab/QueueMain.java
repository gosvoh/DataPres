package SecondLab;

public class QueueMain {
    public static void main(String[] args) {
        runCode(new SecondLab.Array.Queue());
        runCode(new SecondLab.ATDList.Queue());
        runCode(new SecondLab.LinkedList.Queue());
    }

    private static void runCode(IQueue queue) {
        for (int i = 0; i < 5; i++) queue.enqueue(Integer.toString(i).charAt(0));
        System.out.println(queue);
        while (!queue.empty())
            System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println();
    }
}
