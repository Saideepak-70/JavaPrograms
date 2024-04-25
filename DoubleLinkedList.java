package javaprogr;
import java.util.*;

class node1 {
    int data;
    node1 next, prev;
    
    node1(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

public class DoubleLinkedList {
	node1 head, last;
	Scanner scan = new Scanner(System.in);
	void create(int n) {
		if (n == 1) {
			System.out.println("Enter the data of the only node :  ");
			int data = scan.nextInt();
			node1 newnode = new node1(data);
			head = newnode;
			last = newnode;
		}
		else {
			for(int i = 1; i <= n; i++) {
				System.out.println("Enter the data of the "+i+" node : ");
				int new_data = scan.nextInt();
				node1 newnode = new node1(new_data);
				if (head == null) {
					head = newnode;
					last = newnode;
				}
				else {
					node1 temp = head;
					while (temp.next != null) {
						temp = temp.next;
					}
					temp.next = newnode;
					newnode.prev = temp;
					last = newnode;
				}
			}
		}
	}
	void insert_at_first() {
		System.out.print("Enter the data you want to insert at begin : ");
		int data = scan.nextInt();
		node1 newnode = new node1(data);
		newnode.next = head;
		head.prev = newnode;
		head = newnode;
	}
	void insert_at_last() {
		System.out.print("Enter the data you want to insert at last : ");
		int data = scan.nextInt();
		node1 newnode = new node1(data);
		node1 current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newnode;
		newnode.prev = current;
	}
	void insert_at_anywhere() {
		System.out.print("Enter the position you want insert at : ");
		int pos = scan.nextInt();
		System.out.print("Enter the data : ");
		int data = scan.nextInt();
		node1 newnode = new node1(data);
		if (pos == 0) {
			newnode.next = head;
			if (head != null) {
				head.prev = newnode;
			}
			head = newnode;
		}
		else {
			node1 current = head;
			for(int i = 1; i < pos && current.next != null; i++) {
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
			newnode.prev = current;
		}
	}
	void delete_at_first() {
		node1 todelete = head;
		head = head.next;
		todelete.next = null;
		todelete = null;
		head.prev = null;
	}
	void delete_at_last() {
		node1 todelete = head;
		node1 secondlast = null;
		while (todelete.next != null) {
			secondlast = todelete;
			todelete = todelete.next;
		}
		if (secondlast == null) {
			todelete = null;
		}
		else {
			secondlast.next = null;
			todelete = null;
		}
	}
	void delete_at_anywhere() {
		System.out.println("Enter the position you want to delete at : ");
		int pos = scan.nextInt();
		if (pos == 0) {
			node1 todelete = head;
			head = head.next;
			todelete.next = null;
			todelete = null;
		}
		else {
			node1 current = head;
			for(int i = 1; i < pos-1 && current.next != null; i++) {
				current = current.next;
			}
			node1 temp = current.next.next;
			current.next = temp;
			temp.prev = current;
		}
	}
	void print() {
		node1 node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	void reverse_print() {
		node1 node = last;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.prev;
		}
	}
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		list.create(n);
		list.print();
		System.out.print("\n");
		list.reverse_print();
		System.out.print("\n");
		list.insert_at_first();
		list.print();
		System.out.print("\n");
		list.insert_at_last();
		list.print();
		System.out.print("\n");
		list.insert_at_anywhere();
		list.print();
		System.out.print("\n");
		list.delete_at_first();
		list.print();
		System.out.print("\n");
		list.delete_at_last();
		list.print();
		System.out.print("\n");
		list.delete_at_anywhere();
		list.print();
		scan.close();
	}
}    
