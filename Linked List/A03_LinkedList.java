import java.util.Scanner;

public class A03_LinkedList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0, deleteChoice = 0;
        Node start = null;
        Node end = null;
        Node datatodelete = null;

        while(choice != 4) {
            System.out.println("**** Menu ****");
            System.out.println("1. Add value in the link list");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Exit");

            System.out.print("Enter a choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                Node temp = new Node();
                System.out.println("Add");
                System.out.println("**** Menu ****");
                System.out.println("1. Add at end");
                System.out.println("2. Add after a specific value");
                System.out.println("Enter a choice");
                int addchoice = sc.nextInt();
                System.out.println("Enter the data: ");
                temp.data = sc.nextInt();

                if(addchoice == 1){
                    temp.address = null;
                    if(start==null) {
                        start = temp;
                        end = temp;
                    }
                    else{
                        end.address = temp;
                        end = temp;
                    }
                }
                else if(addchoice==2){
                    System.out.println("Enter after which value you want to insert: ");
                    int addafter = sc.nextInt();

                    Node trav = start;
                    while(trav.data != addafter){
                        temp.address = trav.address;
                        trav.address = temp;
                    }
                }

            }
            else if (choice == 2) {
                System.out.println("Display");
                if(start == null){
                    System.out.println("Link list is empty");
                }
                else{
                    Node trav = start;
                    System.out.print("Start--->");
                    while(trav != null){
                        System.out.print(trav.data + "--->");
                        trav = trav.address;
                    }
                    System.out.print("end");
                    System.out.println();
                }
            }
            else if(choice == 3)
            {
                System.out.println("****Deletion Menu****");
                System.out.println("1. Delete from start");
                System.out.println("2. Delete from End");
                System.out.println("3. Delete specific node");
                System.out.println("Enter a delete choice:");
                deleteChoice = sc.nextInt();
                if(deleteChoice == 1)
                {
                    System.out.println("Deleting from start");
                    datatodelete = start;
                    start = datatodelete.address;
                    datatodelete.address = null;
                    System.out.println("Deleted data is: " + datatodelete.data);
                    datatodelete = null;
                }
                else if (deleteChoice == 2)
                {
                    System.out.println("Deleting from end");
                    datatodelete = start;

                    while(datatodelete!=end && datatodelete.address!=end)
                    {
                        if(datatodelete.address != end)
                        {
                            datatodelete = datatodelete.address;
                        }
                    }
                    if(end!=datatodelete)
                    {
                        end = datatodelete;
                        datatodelete.address = null;
                        datatodelete = null;
                    }
                    else
                    {
                        end = null;
                        datatodelete = null;
                        start = null;
                    }

                }
                else if (deleteChoice == 3)
                {

                    System.out.println("Deleting a specific node");
                    System.out.println("Enter the data to delete");
                    int value = sc.nextInt();
//                    while( int i; ;){
//                        System.out.println("Specific");
//                    }
                }
                else
                {
                    System.out.println("Enter a valid delete choice");
                }
            }
            else if (choice == 4)
            {
                System.out.println("Exit");
            }
            else
            {
                System.out.println("Please Enter a valid option");
            }
        }
    }
}
