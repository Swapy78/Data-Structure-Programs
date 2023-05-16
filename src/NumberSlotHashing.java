//Java program for Hashing Function to search a Number in a slot

package demo;

import java.io.IOException;
import java.util.*;

public class NumberSlotHashing {
    private static final int NUM_SLOTS = 10;

    public static void main(String[] args) {
        // Creating a map to store number slots
        Map<Integer, List<Integer>> numberSlots = new HashMap<>();
        
        // Initializing the number slots
        initializeSlots(numberSlots);

        // Reading numbers from a file and store them in appropriate slots
        readNumbersFromFile(numberSlots, "numbers.txt");

        // User input to search a number
        int searchNumber = getUserInput();
        searchNumberInSlots(numberSlots, searchNumber);

        // Saving the numbers in a file
        saveNumbersToFile(numberSlots, "numbers_output.txt");
    }

    // Initializing the number slots
    private static void initializeSlots(Map<Integer, List<Integer>> numberSlots) {
        for (int i = 0; i < NUM_SLOTS; i++) {
            numberSlots.put(i, new LinkedList<>());
        }
    }

    // Reading numbers from a file and store them in appropriate slots
    private static void readNumbersFromFile(Map<Integer, List<Integer>> numberSlots, String filename) {
        try (Scanner scanner = new Scanner(NumberSlotHashing.class.getResourceAsStream(filename))) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                int slot = number % NUM_SLOTS;
                List<Integer> slotNumbers = numberSlots.get(slot);
                slotNumbers.add(number);
            }
        }
    }

    // Getting user input to search a number
    private static int getUserInput() {
        System.out.print("Enter a number to search: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }

    // Searching for a number in the slots
    private static void searchNumberInSlots(Map<Integer, List<Integer>> numberSlots, int searchNumber) {
        int slot = searchNumber % NUM_SLOTS;
        List<Integer> slotNumbers = numberSlots.get(slot);
        if (slotNumbers.contains(searchNumber)) {
            slotNumbers.remove(Integer.valueOf(searchNumber));
            System.out.println("Number found and removed from the slot.");
        } else {
            slotNumbers.add(searchNumber);
            System.out.println("Number not found. Added to the slot.");
        }
    }

    // Saving the numbers in a file
    private static void saveNumbersToFile(Map<Integer, List<Integer>> numberSlots, String filename) {
        try (Formatter formatter = new Formatter(filename)) {
            for (int i = 0; i < NUM_SLOTS; i++) {
                List<Integer> slotNumbers = numberSlots.get(i);
                for (int number : slotNumbers) {
                    formatter.format("%d%n", number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
