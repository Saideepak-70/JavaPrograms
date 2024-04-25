package javaprogr;
import java.util.*;
class node{
	int data;
	node next;
	node(int d){
		data = d;
		next = null;
	}
}

public class CircularLinkedList {
	Scanner scan = new Scanner(System.in);
	node head;
	void createlist(int n) {
		if (n == 1) {
			System.out.println("Enter the data for the only node : ");
			int data = scan.nextInt();
			node newNode = new node(data);
			head = newNode;
			newNode.next = newNode;
		}
		else {
			for(int i = 1; i <= n; i++) {
				System.out.println("Enter the data of the "+i+" data : ");
				int new_data = scan.nextInt();
				node new_node = new node(new_data);
				if (head == null) {
					head = new_node;
					head.next = head;
				}
				else {
					node temp = head;
					while (temp.next != head) {
						temp = temp.next;
					}
					temp.next = new_node;
					new_node.next = head;
				}
			}
		}
	}
	void insert_at_begin() {
		System.out.print("Enter the data you want to insert at begin : ");
		int data = scan.nextInt();
		node newnode = new node(data);
		node current = head;
		while (current.next != head) {
			current = current.next;
		}
		current.next = newnode;
		newnode.next = head;
		head = newnode;
	}
	void insert_at_last() {
		System.out.print("Enter the data you want to insert at last : ");
		int data = scan.nextInt();
		node newnode = new node(data);
		node current = head;
		while (current.next != head) {
			current = current.next;
		}
		current.next = newnode;
		newnode.next = head;
	}
	void insert_at_anywhere() {
		System.out.println("Enter the position : ");
		int pos = scan.nextInt();
		System.out.println("enter the data : ");
		int data = scan.nextInt();
		node newnode = new node(data);
		if (pos == 0) {
			newnode.next = head;
			head = newnode;
		}
		else {
			node current = head;
			for(int i = 1; i < pos && current.next != null; i++) {
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
		}
	}
	void delete_at_first() {
		node start = head;
		head = head.next;
		node current = head;
		while (current.next != head) {
			current = current.next;
		}
		current.next = start.next;
		start.next = null;
	}
	void printlist() {
		  node node = head;
		  do {
			  System.out.print(node.data + " ");
			  node = node.next;
		  }
		  while(node != head);
	}
	public static void main(String[] args) {
		CircularLinkedList c1 = new CircularLinkedList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of nodes : ");
		int n = scan.nextInt();
		c1.createlist(n);
		c1.printlist();
		System.out.print("\n");
		c1.insert_at_begin();
		c1.printlist();
		System.out.print("\n");
		c1.insert_at_last();
		c1.printlist();
		System.out.print("\n");
		c1.insert_at_anywhere();
		c1.printlist();
		System.out.print("\n");
		c1.delete_at_first();
		c1.printlist();
		scan.close();
	}
}
