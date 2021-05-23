package class03.practice;

public class C01_ReversList {
    private class Node {
        private Node next;
        private Integer value;
    }

    private class DoubleNode{
        private DoubleNode pre;
        private DoubleNode next;
        private Integer value;
    }

    private static Node reverList(Node head){
        if(head == null && head.next == null){
            return head;
        }
        Node pre = null;
        Node next = null;
        while(head.next != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }

    private static DoubleNode reversDoubleList(DoubleNode head){
        if(head == null && head.next == null){
            return head;
        }
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head.next != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return head;
    }
}
