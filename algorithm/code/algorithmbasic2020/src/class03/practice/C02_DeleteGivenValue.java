package class03.practice;

import java.net.Inet4Address;

public class C02_DeleteGivenValue {
    private class Node {
        private Node next;
        private Integer value;
    }

    private static Node deleteValue(Node head,int value){
        while(head != null){
            if(head.value != value){
                break;
            }else{
                head = head.next;
            }
        }
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
