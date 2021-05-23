package class03.practice;

import java.util.Stack;

public class C06_TwoStackImplementQueue {
    public class TwoStackQueue {
        private Stack pushStack;
        private Stack popStack;

        public TwoStackQueue() {
            pushStack = new Stack();
            popStack = new Stack();
        }

        public void pushToPop(){
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        public void add(int value) {
            pushStack.push(value);
            pushToPop();
        }

        public int poll(){
            if(popStack.isEmpty() && pushStack.isEmpty()){
                throw new RuntimeException();
            }
            pushToPop();
            return (int) popStack.pop();
        }

        public int peek(){
            if(popStack.isEmpty() && pushStack.isEmpty()){
                throw new RuntimeException();
            }
            pushToPop();
            return (int) popStack.peek();
        }

    }
}
