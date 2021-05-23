package class03.practice;

import class03.Code05_GetMinStack;
import org.omg.SendingContext.RunTime;

import java.util.Stack;

public class C05_GetMinStack {
    private class MyStack{
        private Stack dataStack;
        private Stack minStack;

        public MyStack(){
            dataStack = new Stack();
            minStack = new Stack();
        }

        public void push(int value){
            if(minStack.empty()){
                minStack.push(value);
            }else if(value <= (int)minStack.peek()){
                minStack.push(value);
            }
            dataStack.push(value);
        }

        public Integer pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            int popValue = (int) dataStack.pop();

            if(minStack.empty()){
                throw new RuntimeException("栈为空");
            }else if(popValue == getMin()){
                minStack.pop();
            }
            return popValue;
        }

        public Integer getMin(){
            if(minStack.empty()){
                throw new RuntimeException("栈为空");
            }
            return (Integer) minStack.peek();
        }
    }

    private class MyStack2 {
        private Stack dataStack;
        private Stack minStack;

        public MyStack2(){
            dataStack = new Stack();
            minStack = new Stack();
        }

        public void push(int value){
            if (minStack.empty()) {
                minStack.push(value);
            } else if (value < getMin()) {
                minStack.push(value);
            }else {
                minStack.push(getMin());
            }
            dataStack.push(value);
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new RuntimeException("数据栈为空");
            }
            int value = (int) dataStack.pop();
            minStack.pop();
            return value;
        }


        public int getMin(){
            if (minStack.empty()) {
                throw new RuntimeException("栈为空");
            }
            return (int) minStack.peek();
        }
    }

    public static void main(String[] args) {
        Code05_GetMinStack.MyStack1 stack1 = new Code05_GetMinStack.MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        Code05_GetMinStack.MyStack1 stack2 = new Code05_GetMinStack.MyStack1();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }

}
