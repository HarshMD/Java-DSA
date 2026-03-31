import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST t = new BST();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n**** BST Menu ****");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Preorder");
            System.out.println("4. Inorder");
            System.out.println("5. Postorder");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    t.insertData(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data to delete: ");
                    t.deleteData(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Preorder: ");
                    t.preOrder(t.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    t.inOrder(t.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    t.postOrder(t.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
