package class03.practice;

import class03.Code03_DoubleEndsQueueToStackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C03_DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        public Node<T> next;
        public Node<T> pre;
        public T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;

        private void addFromHead(T value){
            Node<T> cur = new Node(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
        }

        private void addFromBottom(T value){
            Node<T> cur = new Node(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
        }

        public T popFromHead(){
            if(head == null && tail == null){
                return null;
            }
            Node<T> cur = head;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
                cur.next = null;
                head.pre = null;

            }
            return cur.value;
        }

        public T popFromBottom(){
            if(head == null){
                return null;
            }
            Node<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                tail = tail.pre;
                cur.pre = null;
                tail.next = null;
            }
            return cur.value;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    public static class MyStack<T>{
        private DoubleEndsQueue<T> queue;

        public MyStack(){
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFromHead();
        }

        public Boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    public static class MyQueue<T>{
        private DoubleEndsQueue<T> queue;

        public MyQueue(){
            queue = new DoubleEndsQueue();
        }

        public void offer(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFromBottom();
        }

        public Boolean isEmpty(){
            return queue.isEmpty();
        }
    }
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            Code03_DoubleEndsQueueToStackAndQueue.MyStack<Integer> myStack = new Code03_DoubleEndsQueueToStackAndQueue.MyStack<>();
            Code03_DoubleEndsQueueToStackAndQueue.MyQueue<Integer> myQueue = new Code03_DoubleEndsQueueToStackAndQueue.MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }



}
