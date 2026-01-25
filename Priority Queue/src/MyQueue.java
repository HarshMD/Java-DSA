class MyQueue {
    Node start = null;
    Node end = null;

    public void enqueue(int value) {
        Node temp = new Node();
        temp.data = value;
        temp.next = null;
        temp.prev = null;

        if (start == null) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            temp.prev = end;
            end = temp;
        }
    }

    public int dequeue() {
        if (start == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        Node temp = start;
        int deletedData = temp.data;

        if (start == end) {   // only one element
            start = null;
            end = null;
        } else {
            start = start.next;
            start.prev = null;
        }

        temp.next = null;
        return deletedData;
    }

    public void display() {
        if (start == null) {
            System.out.println("Queue is empty");
        } else {
            Node trav = start;
            System.out.print("Front -> ");
            while (trav != null) {
                System.out.print(trav.data + " -> ");
                trav = trav.next;
            }
            System.out.println("Rear");
        }
    }
}
