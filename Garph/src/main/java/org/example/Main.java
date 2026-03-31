package org.example;
import java.util.*;

public class Main {
    static GNode startGraph = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0, numOfNodes, reachableNode;

        while (choice != 3) {
            System.out.println("**** Menu ****");
            System.out.println("1. Create Graph");
            System.out.println("2. Display Graph");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter the number of nodes: ");
                numOfNodes = sc.nextInt();

                GNode lastVertical = null;

                for (int i = 0; i < numOfNodes; i++) {
                    GNode gNew = new GNode();
                    System.out.print("Enter the node data: ");
                    gNew.data = sc.nextInt();
                    gNew.down = null;
                    gNew.next = null;

                    if (startGraph == null) {
                        startGraph = gNew;
                        lastVertical = gNew;
                    } else {
                        lastVertical.down = gNew;
                        lastVertical = gNew;
                    }

                    System.out.print("Enter number of reachable nodes from " + gNew.data + ": ");
                    reachableNode = sc.nextInt();

                    GNode adjacentLast = null;

                    for (int j = 0; j < reachableNode; j++) {
                        GNode adjNew = new GNode();
                        System.out.print("Enter reachable node data: ");
                        adjNew.data = sc.nextInt();
                        adjNew.next = null;
                        adjNew.down = null;

                        if (gNew.next == null) {
                            gNew.next = adjNew;
                            adjacentLast = adjNew;
                        } else {
                            adjacentLast.next = adjNew;
                            adjacentLast = adjNew;
                        }
                    }
                }
            }

            else if (choice == 2) {
                System.out.println("\n**** Graph Display Menu ****");
                System.out.println("1. Normal");
                System.out.println("2. BFS");
                System.out.println("3. DFS");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if(choice == 1){
                    GNode temp = startGraph;
                    while (temp != null) {
                        System.out.print(temp.data + " -> ");
                        GNode adj = temp.next;
                        while (adj != null) {
                            System.out.print(adj.data);
                            if (adj.next != null) {
                                System.out.print(", ");
                            }
                            adj = adj.next;
                        }
                        System.out.println();
                        temp = temp.down;
                    }
                } else if (choice == 2) {
                    System.out.print("BFS: ");
                    bfs();
                    System.out.println();
                }
                else if (choice == 3) {
                    System.out.println("DFS");
                    dfs();
                    System.out.println();
                }
                else if (choice == 4) {
                    System.out.println("Exiting");
                }
                else{
                    System.out.println("Please enter a valid choice");
                }
            }

            else if (choice == 3) {
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Enter valid choice");
            }
        }
        sc.close();
    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        GNode temp = startGraph;
        queue.add(temp.data);
        visited.add(temp.data);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            temp = startGraph;
            while (temp != null) {
                if (temp.data == current) {
                    GNode adj = temp.next;
                    while (adj != null) {
                        if (!visited.contains(adj.data)) {
                            queue.add(adj.data);
                            visited.add(adj.data);
                        }
                        adj = adj.next;
                    }
                    break;
                }
                temp = temp.down;
            }
        }
    }

    static void dfs(){
        if (startGraph == null) {
            System.out.println("Graph is empty");
            return;
        }

        System.out.print("DFS: ");

        java.util.Stack<GNode> stack = new java.util.Stack<>();

        // count total vertices
        int count = 0;
        GNode t = startGraph;
        while (t != null) {
            count++;
            t = t.down;
        }

        boolean visited[] = new boolean[count];

        // start from first node
        stack.push(startGraph);

        while (!stack.isEmpty()) {

            GNode current = stack.pop();

            // find index of current node
            GNode searchIndex = startGraph;
            int index = 0;
            while (searchIndex != null && searchIndex != current) {
                searchIndex = searchIndex.down;
                index++;
            }

            if (!visited[index]) {
                visited[index] = true;
                System.out.print(current.data + " ");
            }

            // push adjacent nodes into stack
            GNode adj = current.next;

            while (adj != null) {

                GNode search = startGraph;
                int adjIndex = 0;

                while (search != null) {
                    if (search.data == adj.data && !visited[adjIndex]) {
                        stack.push(search);
                        break;
                    }
                    search = search.down;
                    adjIndex++;
                }

                adj = adj.next;
            }
        }

        System.out.println();
    }
}