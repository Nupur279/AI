import java.util.Arrays;
import java.util.Scanner;
public class SelectionSort
{
 public static void main(String[] args)
 {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter the size of array: ");
 int size = sc.nextInt();

 int arr[] = new int[size];
 int n = arr.length;

 System.out.println("Enter the elements of array: ");
 for(int input = 0; input< n; input++)
 {
    arr[input]=sc.nextInt();
 }
 for(int i = 0; i < n-1; i++)
 {
    int min_index = i;
    for (int j = i + 1; j < n; j++)
    {
        if(arr[j] < arr[min_index])
        {
            min_index = j;
        }
    }
 
    int temp = arr[min_index];
    arr[min_index] = arr[i];
    arr[i] = temp;
 }
 System.out.println("Sorted array is: " +Arrays.toString(arr));
 
 }
}