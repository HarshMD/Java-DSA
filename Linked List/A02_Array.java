import java.util.Scanner;

public class A02_Array {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 values");
        for(int i=0; i<= arr.length-1; i++){
            System.out.print("Enter value: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("The values you entered are: ");
        for(int i = 0; i<=arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
