import java.util.Scanner;

public class BST {
    Node root = null;
    Node start = null;
    Node end = null;
    Scanner sc = new Scanner(System.in);

    public void insertData(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        Node trav = root;

        if(root == null){
            root = temp;
            return;
        }

        while(trav != null){
            if(temp.data < trav.data){
                if(trav.left != null){
                    trav = trav.left;
                }
                else {
                    trav.left = temp;
                    break;
                }
            } else if (temp.data > trav.data) {
                if(trav.right != null){
                    trav = trav.right;
                }
                else {
                    trav.right = temp;
                    break;
                }
            }
        }
    }

//    public void enqueue(Node temp) {
//        if (start == null) {
//            start = temp;
//            end = temp;
//        } else {
//            end.next = temp;
//            end = temp;
//        }
//    }

    public void dequeue(){
        Node temp = start;

        if(start == null){
            System.out.println("Tree is empty");
        } else {
            System.out.println("Deleted node is:" + end.data);
            end = null;
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
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void inOrder(Node n){
        if(n == null) return;
        else{
            inOrder(n.left);
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
//
//    public void delete(){
//        if(start == null){
//            System.out.println("Tree is empty");
//            return;
//        }
//
//        Node temp = start;
//        while(temp != null){
//
//            if(temp.next == end){
//                System.out.println("Deleted element is: " + end.data);
//                end = null;
//                temp.next = null;
//                end = temp;
//                return;
//            }
//            temp = temp.next;
//        }
//    }
}