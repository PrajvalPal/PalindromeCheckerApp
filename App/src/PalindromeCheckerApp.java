import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeStrategy[] strategies = {new StackStrategy(), new DequeStrategy()};

        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean isPalindrome = strategy.check(input);
            long endTime = System.nanoTime();
            System.out.println("Strategy: " + strategy.getClass().getSimpleName());
            System.out.println("Input: " + input);
            System.out.println("Is Palindrome: " + isPalindrome);
            System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");
        }
    }
}