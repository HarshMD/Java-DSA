
public class Stack {
    Node top = null;
    int counter = 0;

    public void push(Node n){
        Node temp = new Node();
        temp.data = value;
        temp.next = top;
        top = temp;
        counter ++;
    }

    public void pop(){
        if(top == null)
            System.out.println("Stack is empty");
        else{
            Node temp = top;
            top = top.next;
            temp.next = null;
            System.out.println("Popped data is: " + temp.data);
            counter++;
        }
    }

    public void display(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            System.out.print("Top-->");
            Node trav = top;
            while(trav != null){
                System.out.print(trav.data + "->");
                trav = trav.next;
            }
            System.out.println("end");
        }
        System.out.println();
    }
}