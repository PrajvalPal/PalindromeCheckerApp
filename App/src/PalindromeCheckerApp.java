public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String input;

        if (args.length > 0) {
            input = args[0];
        } else {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter a string: ");
            input = scanner.nextLine();
            scanner.close();
        }

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if (input.equals(reversed)) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is not a palindrome.");
        }
    }
}