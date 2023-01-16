package Intro_To_DSA.Linked_List_1;
import java.util.Scanner;

public class Linklist {
    static Scanner sc = new Scanner(System.in);

    static int length(Node head) {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static void print(Node head) {
        Node temp = head;
        System.out.print("Linked-List: ");
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node input() {
        int data = sc.nextInt();
        Node head = null;
        Node tail = null;
        while(data != -1) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        print(head);
        return head;
    }
    public static void main(String[] args) {
        System.out.print("Enter Elements of Linked-List: ");
        Node head = input();
        System.out.print("Length of Linked-List: " + length(head));
    }
    
}
