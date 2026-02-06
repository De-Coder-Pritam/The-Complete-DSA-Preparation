import java.util.Scanner;
public class LinkedListEx {
    private Node head;
    private int length;
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        LinkedListEx ll = new LinkedListEx(23,45,12);
        ll.insertAtEnd(56);
        ll.insertAtFront(8);
        ll.display();

    }
    public LinkedListEx(int... values){
        head = null;
        for(int value: values){
            this.insertAtEnd(value);
        }
    }
    public void insertAtPosition(int num, int pos){
        if(pos<1 || pos>length)  return;
        
    }
    public void insertAtFront(int num){
        length++;
        Node newNode = new Node(num);
        newNode.next=head;
        head=newNode;
    }
    public void insertAtEnd(int num){
        length++;
        Node newNode = new Node(num);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;

        }
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(){
        this.data=0;
        this.next=null;
    }
}
