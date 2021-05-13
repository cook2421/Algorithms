package C_Algorithms.A_Sort.Simple_Slow;

public class B_InsertionSort {
    public void insertionSort(int[] array){
        int length = array.length;
        int temp;
        int j;
        int count = 0;

        for(int i=1; i<length; i++){
            temp = array[i];

            for(j=i-1; j>=0 && temp<array[j]; j--){
                array[j+1] = array[j];
                count++;
            }
            array[j+1] = temp;
        }
        System.out.println("삽입정렬 시행횟수: "+count);
    }



    /*public static void main(String[] args) {
        int[] array = {6,5,7,4,8,2,9,10,1,3};

        InsertionSort insertion = new InsertionSort();

        insertion.insertionSort(array);
    }*/
}

/*

<삽입정렬>

두번째 인덱스부터 자기 앞에 있는 숫자들 사이에 자기 위치 찾아 들어감

*/