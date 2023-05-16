//Java program for ordered list

package demo;

import java.io.*;
import java.util.*;

public class OrderedList {
    private Node head;

    // Node class to represent each element in the linked list
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Adding an element to the list in ascending order
    public void insert(int item) {
        Node newNode = new Node(item);
        if (head == null || item < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && item > current.next.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Removing an element from the list
    public void remove(int item) {
        if (head == null) {
            return;
        }
        if (head.data == item) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.data != item) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        previous.next = current.next;
    }

    // Searching for an element in the list
    public boolean search(int item) {
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reading numbers from a file and create an ordered list
    public static OrderedList createListFromFile(String filename) {
        OrderedList list = new OrderedList();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                list.insert(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Saving the list of numbers to a file
    public static void saveListToFile(OrderedList list, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node current = list.head;
            while (current != null) {
                writer.println(current.data);
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Reading numbers from a file and create an ordered list
        OrderedList list = createListFromFile("numbers.txt");

        // User input to search a number
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int searchNumber = sc.nextInt();

        // Searching for the number in the list
        boolean found = list.search(searchNumber);
        if (found) {
            list.remove(searchNumber);
            System.out.println("Number found and removed from the list.");
        } else {
            list.insert(searchNumber);
            System.out.println("Number not found. Added to the list.");
        }

        // Saving the list of numbers to a file
        saveListToFile(list, "numbers_output.txt");
        sc.close();
    }
}
