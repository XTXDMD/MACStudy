package class03.practice;

import class03.Code07_TwoQueueImplementStack;

import java.util.Queue;
import java.util.Stack;

public class C07_TwoQueueImplementStack {
    public class TwoQueueStack {
        private Queue pushQueue;
        private Queue helpQueue;

        public void push(int value){
            pushQueue.add(value);
        }

        public int pop() {
            while (pushQueue.size() > 1) {
                helpQueue.add(pushQueue.poll());
            }
            int value = (int) pushQueue.poll();
            Queue tmp = pushQueue;
            pushQueue = helpQueue;
            helpQueue = tmp;
            return value;
        }

        public int peek() {
            while (pushQueue.size() > 1) {
                helpQueue.add(pushQueue.poll());
            }
            int value = (int) pushQueue.poll();
            helpQueue.offer(value);
            Queue tmp = pushQueue;
            pushQueue = helpQueue;
            helpQueue = tmp;
            return value;
        }

        public boolean isEmpty() {
            return pushQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        Code07_TwoQueueImplementStack.TwoQueueStack<Integer> myStack = new Code07_TwoQueueImplementStack.TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }
}
