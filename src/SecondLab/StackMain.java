package SecondLab;

import SecondLab.ATDList.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) stack.push(Integer.toString(i).charAt(0));
        System.out.println(stack);
        while (!stack.empty())
            System.out.println(stack.pop());
        System.out.println(stack);
    }
}
