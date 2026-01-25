import java.util.Scanner;

public class Tree {
    Node root = null;
    Node start = null;
    Node end = null;
    Scanner sc = new Scanner(System.in);
    Stack s = new Stack();

    public void insertData(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        temp.next = null;

        if(root == null){
            root = temp;
            enqueue(temp);
            return;
        }

        while(start != null){
//            if(root.left == null){
//                root.left = temp;
//                enqueue(temp);
//                return;
//            }
//            if(root.right == null){
//                root.right = temp;
//                enqueue(temp);
//                return;
//            }
            if(start.left == null){
                start.left = temp;
                enqueue(temp);
                return;
            }
            if(start.right == null){
                start.right = temp;
                enqueue(temp);
                return;
            }
            start = start.next;
        }
    }

    public void enqueue(Node temp) {
        if (start == null) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
    }

    public void display(){
        int choice = 0;
        Node n;
        n = root;

        while(choice != 4){
            System.out.println("**** Display Menu ****");
            System.out.println("1. PreOrder");
            System.out.println("2. Inorder");
            System.out.println("3. Postorder");
            System.out.println("4. Exit");
            System.out.print("Enter your Display choice: ");
            choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Preorder data");
                preOrder(n);
            }
            else if(choice == 2){
                System.out.println("Inorder data");
                inOrder(n);
            }
            else if(choice == 3){
                System.out.println("Postorder data");
                postOrder(n);
            }
            else if(choice == 4){
                System.out.println("Exiting");
            }
            else{
                System.out.println("Invalid choice entered.");
            }
        }
    }

    public void preOrder(Node n){
        if(n == null) return;
        else{
            System.out.println(n.data);
            if(n.left != null){
                s.push(n);
                n = n.left;
            }
            if(n.right != null){
                s.push(n);
                n = n.right;
            }
        }
    }

    public void inOrder(Node n){
        if(n == null) return;
        else{
            inOrder(n.left);
            s.push(n.data);
            System.out.println(n.data);
            inOrder(n.right);
        }
    }

    public void postOrder(Node n){
        if(n == null) return;
        else{
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.data);
        }
    }
}