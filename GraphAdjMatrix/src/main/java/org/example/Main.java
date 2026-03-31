package org.example;
import java.util.Scanner;

public class Main {
    static int[][] graph = null;
    static int numOfNodes = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("**** Menu ****");
            System.out.println("1. Create Graph");
            System.out.println("2. Display Graph");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            System.out.flush();
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter number of nodes: ");
                System.out.flush();
                numOfNodes = sc.nextInt();

                graph = new int[numOfNodes][numOfNodes];

                System.out.println("\nEnter edges:");
                for (int i = 0; i < numOfNodes; i++) {
                    System.out.println("For node " + i + ":");
                    System.out.print("How many connections? ");
                    int connections = sc.nextInt();

                    for (int j = 0; j < connections; j++) {
                        System.out.print("  Connected to node: ");
                        System.out.flush();
                        int dest = sc.nextInt();

                        if (dest >= 0 && dest < numOfNodes) {
                            graph[i][dest] = 1;
                        } else {
                            System.out.println("  Invalid node! Must be 0 to " + (numOfNodes-1));
                            j--;
                        }
                    }
                }
                System.out.println("Graph created successfully!\n");
            }

            else if (choice == 2) {
                if (graph == null) {
                    System.out.println("Create graph first!\n");
                } else {
                    System.out.println("\nAdjacency Matrix:");
                    System.out.print("  ");
                    for (int i = 0; i < numOfNodes; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();

                    for (int i = 0; i < numOfNodes; i++) {
                        System.out.print(i + " ");
                        for (int j = 0; j < numOfNodes; j++) {
                            System.out.print(graph[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("\nConnections:");
                    for (int i = 0; i < numOfNodes; i++) {
                        System.out.print(i + " -> ");
                        boolean hasConnection = false;
                        for (int j = 0; j < numOfNodes; j++) {
                            if (graph[i][j] == 1) {
                                System.out.print(j + " ");
                                hasConnection = true;
                            }
                        }
                        if (!hasConnection) {
                            System.out.print("(none)");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }

            else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
            }

            else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.\n");
            }
        }
        sc.close();
    }
}