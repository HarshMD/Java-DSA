import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();
        int choice = 0;

        while (choice != 4) {
            System.out.println("**** Menu ****");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter data: ");
                int data = sc.nextInt();
                System.out.println("Enter the priority of the data: ");
                int priority = sc.nextInt();
                q.enqueue(data, priority);
            }
            else if (choice == 2) {
                int deleted = q.dequeue();
                if (deleted != -1)
                    System.out.println("Deleted element: " + deleted);
            }
            else if (choice == 3) {
                q.display();
            }
            else if (choice == 4) {
                System.out.println("Exit");
            }
            else {
                System.out.println("Enter valid choice");
            }
        }
    }
}
