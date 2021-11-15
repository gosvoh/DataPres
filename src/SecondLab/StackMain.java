package SecondLab;

public class StackMain {
    public static void main(String[] args) {
        runCode(new SecondLab.Array.Stack());
        runCode(new SecondLab.ATDList.Stack());
        runCode(new SecondLab.LinkedList.Stack());
    }

    private static void runCode(IStack stack) {
        for (int i = 0; i < 5; i++) stack.push(Integer.toString(i).charAt(0));
        System.out.println(stack);
        while (!stack.empty())
            System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println();
    }
}
