class MyQueue {
    Node start = null;
    Node end = null;

    public void enqueue(int value, int priority) {
        Node temp = new Node();
        temp.data = value;
        temp.next = null;
        temp.prev = null;
        temp.priority = priority;
        boolean isdataadded =false;

        if (start == null) {
            start = temp;
            end = temp;
        } else {
            if(temp.priority > start.priority){
                addinthebegning(temp, start);
                isdataadded = true;
            }
            else{
                Node trav = start.next;
                while(trav != null && trav!=end){
                    if(trav.priority < temp.priority){
                        addinthebegning(temp, trav);
                        isdataadded = true;
                        break;
                    }
                    else
                        trav = trav.next;
                }
            }
            if(!isdataadded && end.priority < temp.priority){
                addinthebegning(temp, end);
                isdataadded = true;
            }
            if(!isdataadded){
                addatend(temp, end);
            }
        }
    }

    public void addatend(Node datatoadd, Node currentdata){
        datatoadd.prev = currentdata;
        currentdata.next = datatoadd;
        end = datatoadd;
    }

    public void addinthebegning(Node datatoadd, Node currentdata){
        datatoadd.next = currentdata;
        datatoadd.prev = currentdata.prev;
        currentdata.prev = datatoadd;
        if(datatoadd.prev != null)
            datatoadd.prev.next = datatoadd;
        if(currentdata==end)
            currentdata.next = null;
        if(currentdata == start)
            start = datatoadd;
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
