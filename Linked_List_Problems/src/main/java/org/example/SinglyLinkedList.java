package org.example;

class ListNode{
    public int data;
    ListNode next;
    public ListNode(int d, ListNode me){
        data =d;
        next=me;
    }
    public ListNode(int d){
        data=d;
    }
}
public class SinglyLinkedList {
    public static void main(String[]args){
        ListNode head = null;
        head = insertAtEnd(head,19);
        head = insertAtEnd(head,38);
        head=insertAtEnd(head,57);
        head=insertAtEnd(head,76);
        head = insertAtFront(head,6);
        head = insertAtPosBefore(head,23,3);
        head = insertAtPosAfter(head,27,3);
        display(head);
        head = convertArrayToLL(new int[]{10,20,30,40,50,60});
        display(head);
        ListNode node = searchByValue(head, 30);
        System.out.println(node.data);
        ListNode nd = searchByNode(head,node);
        System.out.println(nd.data);
        System.out.println(lengthOfList(head));
        head = deleteHead(head);
        display(head);
        System.out.println(deleteTail(head));
        System.out.println(deleteByPos(head,3));
        display(head);

    }
    public static int lengthOfList(ListNode head){
        int cnt=0;
        ListNode temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    public static ListNode searchByNode(ListNode head, ListNode node){
        ListNode temp = head;
        while(temp!=null){
            if(temp == node) return temp;
            temp = temp.next;
        }
        return null;
    }
    public static ListNode searchByValue(ListNode head,int val){
        ListNode temp = head;
        while(temp != null){
            if(temp.data == val) return temp;
            temp = temp.next;
        }
        return null;
    }
    public static ListNode deleteByValue(ListNode head){

    }
    public static ListNode convertArrayToLL(int [] arr){
        ListNode head = null;
        ListNode temp = head;
        for(int i=0;i<arr.length;i++){
            ListNode newNode = new ListNode(arr[i]);
            if(head == null){
                head = newNode;
                temp = head;
            }else{
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return head;
    }
    public static int deleteByPos(ListNode head, int pos){
        int data=0;
        ListNode temp = head;
        int cnt=0;
        while(temp != null && temp.next != null){
            cnt++;
            if(cnt == pos-1){
                data=temp.next.data;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return data;
    }
    public static int deleteTail(ListNode head){
        ListNode prev = head;
        if(head == null || head.next == null) return -1;
        while(prev.next.next != null){
            prev = prev.next;
        }
        int data =prev.next.data;
        prev.next = null;
        return data;
    }
    public static ListNode deleteHead(ListNode head){
        if(head == null){
            System.out.println("No element to delete.");
            return null;
        }
        head = head.next;
        return head;

    }
    public static ListNode insertAtPosAfter(ListNode head, int val, int pos){
        int cnt=0;
        if(head == null || pos==1) return new ListNode(val,head);
        ListNode temp = head;
        ListNode newNode = new ListNode(val);
        boolean inserted = false;
        while(temp != null){
            cnt++;
            if(cnt == pos){
                newNode.next = temp.next;
                temp.next=newNode;
                inserted = true;
                break;
            }
            temp=temp.next;
        }
        if(!inserted)System.out.println("Position doesn't exist.");
        return head;
    }
    public static ListNode insertAtPosBefore(ListNode head, int val, int pos){
        int cnt=0;
        if(pos == 1) return new ListNode(val,head);
        ListNode temp = head;
        ListNode newNode = new ListNode(val);
        boolean inserted = false;
        while(temp != null){
            cnt++;
            if(cnt == pos-1){
                newNode.next = temp.next;
                temp.next= newNode;
                inserted = true;
                break;
            }
            temp = temp.next;
        }
        if(!inserted)System.out.println("Position doesn't exist.");
        return head;

    }
    public static ListNode insertAtFront(ListNode head, int val){
        return new ListNode(val,head);
    }
    public static void display(ListNode head){
        ListNode temp = head;
        if(head == null) return;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println(temp.data);
    }
    public static ListNode insertAtEnd(ListNode head,int val){
        if(head == null){
            return head = new ListNode(val);
        }
        ListNode temp = head;
        ListNode end = new ListNode(val);
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=end;
        return head;

    }
}
