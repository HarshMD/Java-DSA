import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        Stack stack = new Stack();

        while(choice != 4) {
            System.out.println("**** Menu ****");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter a value");
                int value = sc.nextInt();
                stack.push(value);

            }
            else if (choice == 2) {
                stack.pop();
            }
            else if(choice == 3){
                stack.display();
            }
            else if (choice == 4) {
                System.out.println("Exit");
            }
            else {
                System.out.println("Please Enter a valid option");
            }
        }
    }
}