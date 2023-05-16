//Java program for Un-Ordered list

package demo;

import java.io.*;
import java.util.*;

public class UnOrderedList<T> {
    private Node<T> head;

    // Node class to represent each element in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Adding an element to the list
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Removing an element from the list
    public void remove(T item) {
        if (head == null) {
            return;
        }
        if (head.data.equals(item)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !current.data.equals(item)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        previous.next = current.next;
    }

    // Searching for an element in the list
    public boolean search(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reading words from a file and create an unordered list
    public static UnOrderedList<String> createListFromFile(String filename) {
        UnOrderedList<String> list = new UnOrderedList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    list.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Saving the list of words to a file
    public static void saveListToFile(UnOrderedList<String> list, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Node<String> current = list.head;
            while (current != null) {
                writer.println(current.data);
                current = current.next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Reading words from a file and create an unordered list
        UnOrderedList<String> list = createListFromFile("words.txt");

        // User input to search a word
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = sc.nextLine();

        // Searching for the word in the list
        boolean found = list.search(searchWord);
        if (found) {
            list.remove(searchWord);
            System.out.println("Word found and removed from the list.");
        } else {
            list.add(searchWord);
            System.out.println("Word not found. Added to the list.");
        }

        // Saving the list of words to a file
        saveListToFile(list, "words_output.txt");
        sc.close();
    }
}
