import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        int[] arr2 = Arrays.copyOfRange(arr, 0, 4);
        int[] arr3 = Arrays.copyOfRange(arr, 4, 8);

        for(int a : arr2){
            System.out.print(a);
        }
        System.out.println();
        for(int a : arr3){
            System.out.print(a);
        }
    }
}