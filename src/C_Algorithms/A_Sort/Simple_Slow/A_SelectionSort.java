package C_Algorithms.A_Sort.Simple_Slow;

public class A_SelectionSort {
    public void selectionSort(int[] array){
        int length = array.length;
        int min;
        int temp;

        for(int i=0; i<length-1; i++){  // 마지막 요소는 자연스럽게 정렬됨
            min = i;

            for(int j=i+1; j<length; j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }

            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    /*public static void main(String[] args) {
        int[] array = {6,5,7,4,8,2,9,10,1,3};

        SelectionSort selection = new SelectionSort();

        selection.selectionSort(array);
    }*/
}



/*

<선택정렬>

인덱스 순으로 자기 뒤에 있는 값중 최소값과 자리바꿈
(마지막 인덱스는 시행하지 않아도 정렬됨)

*/

