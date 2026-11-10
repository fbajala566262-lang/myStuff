package pkg; ///frb.was.here

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    static int count;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addElements();
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    generatePermutations();
                    break;
                case 4:
                    generateCombinations();
                    break;
                case 5:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue

    // Ask how many elements to add
    // Use queue.add() to insert elements

    static void addElements() {
        System.out.println("Please enter 5 elements to fill the queue:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter element " + i + ": ");
            queue.add(input.next());
        }
        System.out.println("Elements added.");

        // Dequeue two elements (Task 1) if possible
        if (queue.size() >= 2) {
            System.out.println("Queue: " + queue);
            System.out.println("Dequeued: " + queue.poll());
            System.out.println("Dequeued: " + queue.poll());
            System.out.println("Front now: " + queue.peek());
        }
    }

    // TODO 2: Display all elements in the Queue
    // Display the contents of the Queue
    static void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue: " + queue);
        }
    }

    // TODO 3: Generate all possible permutations
    // Ask how many elements should be selected (r)
    // Generate all possible arrangements
    // Display the total number of permutations
    static void generatePermutations() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
        displayQueue();
        System.out.print("\nEnter number of elements to arrange: ");
        int r = input.nextInt();
        if (r < 1 || r > queue.size()) {
            System.out.println("Invalid number!");
            return;
        }
        System.out.println();
        List<String> items = new ArrayList<>(queue);
        count = 0;
        permuteHelper(items, new boolean[items.size()], new ArrayList<>(), r);
        System.out.println("\nTotal Permutations: " + count);
    }
    // Ask how many elements should be selected (r)
    // Generate all possible arrangements
    // Display the total number of permutations
    static void permuteHelper(List<String> items, boolean[] used, List<String> current, int r) {
        if (current.size() == r) {
            System.out.println(String.join("", current));
            count++;
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(items.get(i));
                permuteHelper(items, used, current, r);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    // Ask how many elements should be selected (r)
    // Generate all possible arrangements
    // Display the total number of permutations
    
    
    

    // TODO 4: Generate all possible combinations
    // Ask how many elements should be selected (r)
    // Generate all possible selections
    // Avoid duplicate combinations
    // Display the total number of combinations

    static void generateCombinations() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
        displayQueue();
        System.out.print("\nEnter number of elements to select: ");
        int r = input.nextInt();
        if (r < 1 || r > queue.size()) {
            System.out.println("Invalid number!");
            return;
        }
        System.out.println();
        List<String> items = new ArrayList<>(queue);
        count = 0;
        combine(items, 0, new ArrayList<>(), r);
        System.out.println("\nTotal Combinations: " + count);
    }

    // start index prevents duplicates (AB and BA are the same)
    static void combine(List<String> items, int start, List<String> current, int r) {
        if (current.size() == r) {
            System.out.println(String.join("", current));
            count++;
            return;
        }
        for (int i = start; i < items.size(); i++) {
            current.add(items.get(i));
            combine(items, i + 1, current, r);
            current.remove(current.size() - 1);
        }
    }
    // Ask how many elements should be selected (r)
    // Generate all possible selections
    // Avoid duplicate combinations
    // Display the total number of combinations

}
