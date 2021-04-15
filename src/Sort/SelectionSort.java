package Sort;

public class SelectionSort {
    public void selectionSort(int[] array){
        int length = array.length;
        int min;
        int temp;
        int count = 0;

        for(int i=0; i<length-1; i++){  // 마지막 요소는 자연스럽게 정렬됨
            min = i;

            for(int j=i+1; j<length; j++){
                if(array[min] > array[j]){
                    min = j;
                    count++;
                }
            }

            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        System.out.println("선택정렬 시행횟수: "+count);
    }



    /*public static void main(String[] args) {
        int[] array = {6,5,7,4,8,2,9,10,1,3};

        SelectionSort selection = new SelectionSort();

        selection.selectionSort(array);
    }*/
}
