package SecondLab;

import SecondLab.ATDList.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 5; i++) queue.enqueue(Integer.toString(i).charAt(0));
        System.out.println(queue);
        while (!queue.empty())
            System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
