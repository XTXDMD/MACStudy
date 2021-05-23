package class03.practice;

import javax.swing.*;

public class C04_RingArray {
    private int head = 0;
    private int tail = 0;
    private int limit;
    private int size = 0;
    private int[] arr;

    public C04_RingArray(int limit) {
        this.limit = limit;
        this.arr = new int[limit];
    }

    public void push(int value){
        if(size == limit){
            throw new RuntimeException("队列已满");
        }
        size++;
        arr[head] = value;
        head = getNextIndex(head);
    }

    public int pop(){
        if(size <= 0){
            throw new RuntimeException("队列为空");
        }
        size--;
        int ans = arr[tail];
        tail = getNextIndex(tail);
        return ans;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getNextIndex(int index) {
        return index < limit - 1 ? index + 1 : 0;
    }
}
