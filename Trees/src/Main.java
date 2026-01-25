    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Tree t = new Tree();
            int choice = 0;

                while (choice != 4) {
                System.out.println("**** Menu ****");
                System.out.println("1. Insert");
                System.out.println("2. Delete");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    t.insertData(data);
                }
                else if (choice == 2) {
                    t.delete();
                }
                else if (choice == 3) {
                    t.display();
                    System.out.println("Display");
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