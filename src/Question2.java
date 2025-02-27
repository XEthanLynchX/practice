import java.util.ArrayList;
import java.util.Scanner;

abstract class MathHandler {
    public abstract int arrayListHandler(ArrayList<Integer> numbers);
}

class AdditionHandler extends MathHandler {
    @Override
    public int arrayListHandler(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

class ProductHandler extends MathHandler {
    @Override
    public int arrayListHandler(ArrayList<Integer> numbers) {
        int product = 1;
        for (int num : numbers) {
            product *= num;
        }
        return product;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Enter a number or 'done': ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done'.");
            }
        }

        AdditionHandler additionHandler = new AdditionHandler();
        ProductHandler productHandler = new ProductHandler();

        int sum = additionHandler.arrayListHandler(numbers);
        int product = productHandler.arrayListHandler(numbers);

        System.out.println("Sum of numbers: " + sum);
        System.out.println("Product of numbers: " + product);
    }
}