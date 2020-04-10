package SortAlgorithms;

public class BubbleSort {

    public void bubbleSort(int array[]){
        int length = array.length;
        int count = 0;

        for(int i=length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;

                    count++;
                }
            }
        }

        System.out.println("시행횟수: "+count);
    }



    public static void main(String[] args) {
        int[] array = {6,5,7,4,8,2,9,10,1,3};

        BubbleSort bubble = new BubbleSort();

        bubble.bubbleSort(array);
    }
}
